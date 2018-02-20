<?php
    /**
     * Making a SPARQL SELECT query
     *
     * This example creates a new SPARQL client, pointing at the
     * dbpedia.org endpoint. It then makes a SELECT query that
     * returns all of the countries in DBpedia along with an
     * english label.
     *
     * Note how the namespace prefix declarations are automatically
     * added to the query.
     *
     * @package    EasyRdf
     * @copyright  Copyright (c) 2009-2013 Nicholas J Humfrey
     * @license    http://unlicense.org/
     */

/*
  Other Authors that modified the code:
  Jevan Pipitone, Last Edited 28 January 2018
*/

    set_include_path(get_include_path() . PATH_SEPARATOR . '../lib/');
    // require_once "EasyRdf.php";
    require_once "../include/html_tag_helpers.php";
    require 'vendor/autoload.php';

    // Setup some additional prefixes for DBpedia
    /*
    EasyRdf_Namespace::set('category', 'http://dbpedia.org/resource/Category:');
    EasyRdf_Namespace::set('dbpedia', 'http://dbpedia.org/resource/');
    EasyRdf_Namespace::set('dbo', 'http://dbpedia.org/ontology/');
    EasyRdf_Namespace::set('dbp', 'http://dbpedia.org/property/');
    */
    //EasyRdf_Namespace::set('', 'http://example.org/relatives:');

    $sparql = new EasyRdf_Sparql_Client('http://127.0.0.1:3030/relativesWithOwlInferencingAndOpenlletReasoner/query');
?>
<html>
<head>
  <title>EasyRdf Basic Sparql Example</title>
  <meta http-equiv="content-type" content="text/html; charset=utf-8" />
</head>
<body>
<h1>EasyRdf Basic Sparql Example - Grandparents query from Apache Fuseki Endpoint</h1>

<ul>
<?php
    $result = $sparql->query(
      'PREFIX : <http://example.org/relatives#> ' .
      'SELECT ?gp WHERE { ' .
      '  ?gc :hasGrandparent ?gp . ' .
      '  ?gc a :Person . ' .
      '}'
    );
    foreach ($result as $row) {
        echo "<li>" . $row->gp . "\n";
    }
?>
</ul>

</body>
</html>
