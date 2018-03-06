/*
Authors:
Jevan Pipitone, Last Edit: 6 March 2018
*/

import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.sparql.SPARQLRepository;

import java.util.List;
import org.eclipse.rdf4j.query.BindingSet;
import org.eclipse.rdf4j.repository.util.Repositories;
import org.eclipse.rdf4j.query.TupleQuery;
import org.eclipse.rdf4j.query.QueryResults;

// https://www.slf4j.org/manual.html
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class rdf4jTest1 {
   public static void main(String[] args) {

     // http://docs.rdf4j.org/javadoc/latest/
     // http://docs.rdf4j.org/#_reference_documentation
     // Jevan: I found that if I just pass a single parameter to SPARQLRepository for both query and update,
     // it does not work
     String queryEndpointUrl = "http://127.0.0.1:3030/relativesTdbWithOwlInferencingAndOpenlletReasoner/query";
     String updateEndpointUrl = "http://127.0.0.1:3030/relativesTdbWithOwlInferencingAndOpenlletReasoner/update";
     Repository repo = new SPARQLRepository(queryEndpointUrl, updateEndpointUrl);
     repo.initialize();

     List<BindingSet> results = Repositories.tupleQuery(repo,
      "PREFIX : <http://example.org/relatives#> SELECT ?gc ?gp WHERE { ?gc :hasGrandparent ?gp . ?gc a :Person . }",
      r -> QueryResults.asList(r));

     System.out.println("Grandparents query using Apache Fuseki. There are a total of "+results.size()+" results."+System.lineSeparator());
     for (BindingSet solution : results) {
        // http://docs.rdf4j.org/programming/#_the_repositorymanager_and_repositoryprovider
        System.out.println("?gc = " + solution.getValue("gc"));
        System.out.println("?gp = " + solution.getValue("gp")+System.lineSeparator());
     }
  }
}
