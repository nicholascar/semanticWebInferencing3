package semweb;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jena.cmdline.CommandLine;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.hp.hpl.jena.datatypes.TypeMapper;
import com.hp.hpl.jena.graph.Node;
import com.hp.hpl.jena.graph.Triple;
import com.hp.hpl.jena.rdf.model.AnonId;
import com.hp.hpl.jena.shared.PrefixMapping;

import de.fuberlin.wiwiss.ng4j.semwebclient.CommandLineQuery;

/**
 * The semwebquery command line tool. Executes SPARQL or
 * find queries from the command line.
 * 
 * TODO: Machine-readable output of query results? 
 *       RDF/XML, N3, N-Triple, SPARQL XML results, SPARQL JSON results, CSV, ...
 * 
 * @author Richard Cyganiak (richard@cyganiak.de)
 * @version $Id: query.java,v 1.11 2009/08/14 07:23:43 hartig Exp $
 */
public class query {
	private static boolean verbose = false;
	
	public static void main(String[] args) {
		CommandLine cmd = new CommandLine();
		cmd.add(true, "sparql");
		cmd.add(true, "sparqlfile");
		cmd.add(true, "find");
		cmd.add(true, "maxsteps");
		cmd.add(true, "maxfilesize");
		cmd.add(true, "maxthreads");
		cmd.add(true, "timeout");
		cmd.add(true, "load");
		cmd.add(true, "loadtrig");
		cmd.add(true, "savetrig");
		cmd.add(false, "retrieveduris");
		cmd.add(false, "faileduris");
		cmd.add(false, "redirecteduris");
		cmd.add(false, "verbose");
		cmd.add(false, "grddl");
		cmd.add(false, "NoRDFa");
		cmd.add(false, "sindice");
		cmd.add(true, "resultfmt");
		try {
			cmd.process(args);
			if (!cmd.hasArgs() || cmd.hasItems()) {
				printUsage();
				System.exit(0);
			}
			CommandLineQuery client = initClient(cmd);
			client.run();
		} catch (Exception ex) {
			if (verbose || ex.getMessage() == null) {
				ex.printStackTrace();
			} else {
				System.err.println(ex.getMessage());
			}
			System.exit(1);
		}
	}
	
	private static CommandLineQuery initClient(CommandLine cmd) {
		CommandLineQuery client = new CommandLineQuery();
		String queryType = null;
		if (cmd.hasArg("sparql")) {
			client.setSPARQLQuery(cmd.getValue("sparql"));
			queryType = "sparql";
		}
		if (cmd.hasArg("sparqlfile")) {
			if (queryType != null) {
				throw new IllegalArgumentException("Can't combine -" + queryType + " and -sparqlfile");
			}
			client.setSPARQLFile(cmd.getValue("sparqlfile"));
			queryType = "sparqlfile";
		}
		if (cmd.hasArg("find")) {
			if (queryType != null) {
				throw new IllegalArgumentException("Can't combine -" + queryType + " and -find");
			}
			client.setFindTriple(parseTriplePattern(cmd.getValue("find")));
			queryType = "find";
		}
		if (queryType == null) {
			throw new IllegalArgumentException("No query specified; use -sparql, -sparqlfile or -file");
		}
		if (cmd.hasArg("maxsteps")) {
			client.setMaxSteps((int) parseNumber(cmd.getValue("maxsteps"), "maxsteps", 0));
		}
		if (cmd.hasArg("maxfilesize")) {
			client.setMaxFilesize((int) parseNumber(cmd.getValue("maxfilesize"), "maxfilesize", 0));
		}
		if (cmd.hasArg("maxthreads")) {
			client.setMaxThreads((int) parseNumber(cmd.getValue("maxthreads"), "maxthreads", 0));
		}
		if (cmd.hasArg("timeout")) {
			client.setTimeout(parseNumber(cmd.getValue("timeout"), "timeout", 0) * 1000);
		} else {
			client.setTimeout(60000);
		}
		if (cmd.hasArg("grddl")) {
			client.setEnableGrddl(true);
		}
		if (cmd.hasArg("NoRDFa")) {
			client.setEnableRDFa(false);
		}
		if (cmd.hasArg("sindice")) {
			client.setEnableSindiceSearch(true);
		}
		if (cmd.hasArg("load")) {
			Iterator it = cmd.getValues("load").iterator();
			while (it.hasNext()) {
				String value = (String) it.next();
				client.addSourceURI(value);
			}
		}
		if (cmd.hasArg("loadtrig")) {
			client.setLoadGraphSet(cmd.getValue("loadtrig"), "TRIG");
		}
		if (cmd.hasArg("savetrig")) {
			client.setWriteGraphSet(cmd.getValue("savetrig"), "TRIG");
		}
		if (cmd.hasArg("retrieveduris")) {
			client.setOutputRetrievedURIs(true);
		}
		if (cmd.hasArg("faileduris")) {
			client.setOutputFailedURIs(true);
		}
		if (cmd.hasArg("redirecteduris")) {
			client.setOutputRedirectedURIs(true);
		}
		if (cmd.hasArg("resultfmt")) {
			client.setResultFormat( cmd.getValue("resultfmt") );
		}
		if (cmd.hasArg("verbose")) {
			verbose = true;
			client.setVerbose(true);
			Logger.getLogger("de.fuberlin.wiwiss.ng4j.semwebclient").setLevel(Level.ALL);
		}
		return client;
	}

	private static void printUsage() {
		System.out.println("usage: semwebquery [parameters]");
		System.out.println();
		System.out.println("    -sparql <query>        Execute a SPARQL query");
		System.out.println("    -sparqlfile <file>     Execute a SPARQL query loaded from a file");
		System.out.println("    -find \"s p o\"          Execute a find query with an N-Triple style pattern;");
		System.out.println("                           use ANY as a wildcard");
		System.out.println("    -maxsteps <steps>      Set maximal depth of link following. Default: 3");
		System.out.println("    -maxfilesize <size>    Set maximal filesize in bytes of URIs to retrieve. Default: 100000000");
		System.out.println("    -maxthreads <threads>  Set number of threads for loading URIs. Default: 10");
		System.out.println("    -timeout <seconds>     Set query timeout. Default: 60 seconds");
		System.out.println("    -load <URL>            Load seed graph from the Web");
		System.out.println("    -grddl                 Perform GRDDL transformations (Notice, GRDDL support is deprecated!!)");
		System.out.println("    -NoRDFa                Disables RDFa support");
		System.out.println("    -sindice               Enables Sindice-based URI search during query execution");
		System.out.println("    -loadtrig <file>       Load seed graphs from a TriG file before starting");
		System.out.println("    -savetrig <file>       Save loaded graphs to a TriG file after finishing");
		System.out.println("    -retrieveduris         Output a list of all successfully retrieved URIs");
		System.out.println("    -faileduris            Output a list of URIs that could not be retrieved");
		System.out.println("    -redirecteduris        Output a mapping of URIs that have been redirected");
		System.out.println("    -resultfmt <format>    Specifies the output format for the result of a SPARQL query:");
		System.out.println("                           - for SELECT and ASK queries use TXT, XML, or JSON");
		System.out.println("                             (default: TXT);");
		System.out.println("                           - for CONSTRUCT or DESCRIBE queries use RDF/XML,");
		System.out.println("                             N-TRIPLE, TURTLE, or N3 (default: RDF/XML)");
		System.out.println("    -verbose               Show additional progress information");
		System.out.println();
	}
	
	private static Triple parseTriplePattern(String s) {
		String[] nodes = s.split(" +", 3);
		if (nodes.length != 3) {
			throw new IllegalArgumentException("-find: Failed to parse triple pattern");
		}
		Node subject = parseNode(nodes[0], PrefixMapping.Extended);
		Node predicate = parseNode(nodes[1], PrefixMapping.Extended);
		Node object = parseNode(nodes[2], PrefixMapping.Extended);
		return new Triple(subject, predicate, object);
	}

	private static Node parseNode(String s, PrefixMapping prefixes) {
		if ("ANY".equals(s)) {
			return Node.ANY;
		}
		Matcher m = Pattern.compile("^_:(.*)$").matcher(s);
		if (m.matches()) {
			return Node.createAnon(new AnonId(m.group(1)));	
		}
		m = Pattern.compile("^<(.*)>$").matcher(s);
		if (m.matches()) {
			return Node.createURI(m.group(1));
		}
		m = Pattern.compile("^([a-zA-Z0-9_-]*):(.*)$").matcher(s);
		if (m.matches()) {
			if (prefixes.getNsPrefixURI(m.group(1)) == null) {
				throw new IllegalArgumentException(
						"-find: Unknown prefix: '" + m.group(1) + "'");
			}
			return Node.createURI(prefixes.getNsPrefixURI(m.group(1)) + m.group(2));
		}
		m = Pattern.compile("^(?:'.*'|\".*\")$").matcher(s);
		if (m.matches()) {
			return Node.createLiteral(m.group(1).substring(1, m.group(1).length() - 2));
		}
		m = Pattern.compile("^(?:'.*'|\".*\")@([a-zA-Z0-9_-]+)$").matcher(s);
		if (m.matches()) {
			return Node.createLiteral(m.group(1).substring(1, m.group(1).length() - 2), 
					m.group(2), null);
		}
		m = Pattern.compile("^(?:'.*'|\".*\")^^(.*)$").matcher(s);
		if (m.matches()) {
			return Node.createLiteral(m.group(1).substring(1, m.group(1).length() - 2), 
					null, TypeMapper.getInstance().getSafeTypeByName(
					parseNode(m.group(2), prefixes).getURI()));
		}
		throw new IllegalArgumentException("-find: Failed to parse node: '" + s + "'");
	}
	
	private static long parseNumber(String s, String arg, long minimum) {
		try {
			long result = Long.parseLong(s);
			if (result < minimum) {
				throw new IllegalArgumentException("-" + arg + ": minimum is " + minimum);
			}
			return result;
		} catch (NumberFormatException ex) {
			throw new IllegalArgumentException("-" + arg + ": '" + s + "' is not a number");
		}
	}
}
