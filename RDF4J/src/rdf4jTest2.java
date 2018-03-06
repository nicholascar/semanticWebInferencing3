// http://docs.rdf4j.org/programming/#_the_repositorymanager_and_repositoryprovider
// http://docs.rdf4j.org/rdf-tutorial/

/*
Authors:
Jevan Pipitone, Last Edit: 6 March 2018
*/

import java.io.InputStream;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.rio.Rio;
import org.eclipse.rdf4j.rio.RDFFormat;

import org.eclipse.rdf4j.sail.spin.SpinSail;
import org.eclipse.rdf4j.sail.inferencer.fc.ForwardChainingRDFSInferencer;
import org.eclipse.rdf4j.sail.inferencer.fc.DedupingInferencer;
import org.eclipse.rdf4j.sail.memory.MemoryStore;

import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.sail.SailRepository;

import org.eclipse.rdf4j.repository.RepositoryConnection;

import org.eclipse.rdf4j.repository.RepositoryResult;
import org.eclipse.rdf4j.model.Statement;

import org.eclipse.rdf4j.query.TupleQuery;
import org.eclipse.rdf4j.query.TupleQueryResult;
import org.eclipse.rdf4j.query.BindingSet;

public class rdf4jTest2 {
   public static void main(String[] args) {

     // First load our RDF file as a Model.
     String filename = "/relatives.ttl"; // must start with a / and it does not work if i put /../data/relatives.ttl
     InputStream input = rdf4jTest2.class.getResourceAsStream(filename);
     Model model = null;
     try {
       model = Rio.parse(input, "", RDFFormat.TURTLE);
     } catch (Exception e) {
       System.err.println("Caught Exception: " + e.getMessage());
     }

     // create a basic Sail Stack with a simple Memory Store, full RDFS reasoning,
     // and SPIN inferencing support
     SpinSail spinSail = new SpinSail();
     spinSail.setBaseSail(
             new ForwardChainingRDFSInferencer(
                    new DedupingInferencer(new MemoryStore())
             )
     );

     // Create a new Repository. Here, we choose a database implementation
     // that simply stores everything in main memory.
     //Repository db = new SailRepository(new MemoryStore());
     Repository db = new SailRepository(spinSail);
     db.initialize();

     // Open a connection to the database
     try (RepositoryConnection conn = db.getConnection()) {
       // add the model
     	 conn.add(model);

       String queryString1 = "PREFIX : <http://example.org/relatives#> SELECT ?gc ?gp WHERE { ?gc :hasGrandparent ?gp . ?gc a :Person . }";
       TupleQuery query1 = conn.prepareTupleQuery(queryString1);
       // A QueryResult is also an AutoCloseable resource, so make sure it gets
       // closed when done.
       try (TupleQueryResult result1 = query1.evaluate()) {
         int resultsCount1 = 0;
         while (result1.hasNext()) {
           resultsCount1 += 1;
     	     BindingSet solution = result1.next();
     	     System.out.println("?gc = " + solution.getValue("gc"));
     	     System.out.println("?gp = " + solution.getValue("gp")+System.lineSeparator());
     	   }
         System.out.println("Grandparent query has "+resultsCount1+" results."+System.lineSeparator());
       }

       String queryString2 = "PREFIX : <http://example.org/relatives#> SELECT * WHERE { ?p :hasChild ?c . }";
       TupleQuery query2 = conn.prepareTupleQuery(queryString2);
       // A QueryResult is also an AutoCloseable resource, so make sure it gets
       // closed when done.
       try (TupleQueryResult result2 = query2.evaluate()) {
         int resultsCount2 = 0;
         while (result2.hasNext()) {
           resultsCount2 += 1;
     	     BindingSet solution = result2.next();
     	     System.out.println("?p = " + solution.getValue("p"));
     	     System.out.println("?c = " + solution.getValue("c")+System.lineSeparator());
     	   }
         System.out.println("hasChild query has "+resultsCount2+" results."+System.lineSeparator());
       }

       // let's check that our data is actually in the database
       try (RepositoryResult<Statement> result3 = conn.getStatements(null, null, null);) {
         while (result3.hasNext()) {
            Statement st = result3.next();
            System.out.println("db contains: " + st);
          }
       }

     } finally {
       // before our program exits, make sure the database is properly shut down.
     	 db.shutDown();
     } // try (RepositoryConnection)
  } // public static void main
} // public class rdf4j-test2
