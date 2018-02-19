using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

using VDS.RDF;
using VDS.RDF.Parsing;
using VDS.RDF.Query;
using VDS.RDF.Query.Datasets;
using VDS.RDF.Writing.Formatting;

namespace Dotnetrdf_Test
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            tbOutput.Text = "";
            tbOutput.Text += "Starting - " + button1.Text + Environment.NewLine;
            try
            {
                // https://github.com/dotnetrdf/dotnetrdf/wiki/UserGuide
                // https://github.com/dotnetrdf/dotnetrdf/wiki/UserGuide-Reading-RDF
                IGraph g1 = new Graph();
                TurtleParser ttlparser = new TurtleParser();
                ttlparser.Load(g1, "data/relatives.ttl");
                tbOutput.Text += "Loaded relatives.ttl" + Environment.NewLine;

                // https://github.com/dotnetrdf/dotnetrdf/wiki/UserGuide-Querying-With-SPARQL
                TripleStore store = new TripleStore();
                store.Add(g1);
                InMemoryDataset ds = new InMemoryDataset(store,true);
                ISparqlQueryProcessor processor = new LeviathanQueryProcessor(ds);
                SparqlQueryParser parser = new SparqlQueryParser();
                //SparqlQuery q = parser.ParseFromString("PREFIX : <http://example.org/relatives#> SELECT * WHERE { ?s a ?type }");
                SparqlQuery q1 = parser.ParseFromString("PREFIX : <http://example.org/relatives#> SELECT ?gc ?gp WHERE { ?gc :hasGrandparent ?gp . ?gc a :Person . }");
                var results1 = processor.ProcessQuery(q1);
                if (results1 is SparqlResultSet)
                {
                    SparqlResultSet rset1 = (SparqlResultSet)results1;
                    tbOutput.Text += "Grandparent query gave " + rset1.Count + " result(s)" + Environment.NewLine;
                }
                SparqlQuery q2 = parser.ParseFromString("PREFIX : <http://example.org/relatives#> SELECT * WHERE { ?a ?b ?c }");
                var results2 = processor.ProcessQuery(q2);
                tbOutput.Text += "Results for * query of all triples:" + Environment.NewLine;
                /*
                
                */
                // https://github.com/dotnetrdf/dotnetrdf/wiki/UserGuide-Working-With-Triple-Stores
                if (results2 is SparqlResultSet)
                {
                    //Print out the Results
                    SparqlResultSet rset2 = (SparqlResultSet)results2;
                    foreach (SparqlResult result in rset2)
                    {
                        tbOutput.Text += result.ToString()+Environment.NewLine;
                    }
                }
            } catch (RdfParseException parseEx) {
                //This indicates a parser error e.g unexpected character, premature end of input, invalid syntax etc.
                tbOutput.Text += "Parser Error" + Environment.NewLine;
                tbOutput.Text += parseEx.Message + Environment.NewLine;
            } catch (RdfException rdfEx) {
                //This represents a RDF error e.g. illegal triple for the given syntax, undefined namespace
                tbOutput.Text += "RDF Error" + Environment.NewLine;
                tbOutput.Text += rdfEx.Message + Environment.NewLine;
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            tbOutput.Text = "";
            tbOutput.Text += "Starting - " + button2.Text + Environment.NewLine;
            try
            {
                SparqlRemoteEndpoint endpoint = new SparqlRemoteEndpoint(new Uri("http://127.0.0.1:3030/relativesWithOwlInferencingAndOpenlletReasoner/query"));
                // must be a CONSTRUCT or DESCRIBE query
                // https://github.com/dotnetrdf/dotnetrdf/wiki/UserGuide-Working-With-Graphs
                String query = "PREFIX : <http://example.org/relatives#> CONSTRUCT { ?gc :hasGrandparent ?gp } WHERE { ?gc :hasGrandparent ?gp . ?gc a :Person . }";
                IGraph g1 = endpoint.QueryWithResultGraph(query);
                //Print out the Results
                NTriplesFormatter formatter = new NTriplesFormatter();
                tbOutput.Text += "Total tuples: " + g1.Triples.Count + Environment.NewLine;
                foreach (Triple t in g1.Triples)
                {
                    tbOutput.Text += t.ToString(formatter) + Environment.NewLine + Environment.NewLine;
                }
            } catch (RdfParseException parseEx) {
                //This indicates a parser error e.g unexpected character, premature end of input, invalid syntax etc.
                tbOutput.Text += "Parser Error" + Environment.NewLine;
                tbOutput.Text += parseEx.Message + Environment.NewLine;
            } catch (RdfException rdfEx) {
                //This represents a RDF error e.g. illegal triple for the given syntax, undefined namespace
                tbOutput.Text += "RDF Error" + Environment.NewLine;
                tbOutput.Text += rdfEx.Message + Environment.NewLine;
            }
        }
    }
}
