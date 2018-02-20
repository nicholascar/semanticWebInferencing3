<?php
require 'vendor/autoload.php';

$graph = new EasyRdf_Graph();
$graph->parseFile("../data/foaf.rdf", "rdfxml"); // https://groups.google.com/forum/#!topic/easyrdf/flX3d2e4U3Q
$me = $graph->primaryTopic("http://njh.me/foaf.rdf");
echo "My name is: ".$me->get('foaf:name')."\n";
?>
