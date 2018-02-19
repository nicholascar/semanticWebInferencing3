<?php
require 'vendor/autoload.php';
require 'inc/Graphite.php';

$graph = new Graphite();

// Graphite works with sparql construct only, which returns RDF not a table of results
// https://www.w3.org/TR/rdf-sparql-query/#construct
// http://graphite.ecs.soton.ac.uk/

$endpoint = 'http://127.0.0.1:3030/relativesWithOwlInferencingAndOpenlletReasoner/query';
$query = 'PREFIX : <http://example.org/relatives#> ' .
'CONSTRUCT { ?gc :hasGrandparent ?gp }' .
' WHERE { ' .
'  ?gc :hasGrandparent ?gp . ' .
'  ?gc a :Person . ' .
'}';

$count = $graph->loadSPARQL( $endpoint, $query );
print $count;
print $graph->dump();

?>
