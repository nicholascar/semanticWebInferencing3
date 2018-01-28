<?php
    /**
     * GraphViz rendering example
     *
     * This example demonstrates converting an EasyRdf_Graph into the
     * GraphViz graph file language. Using the 'Use Labels' option, you
     * can have resource URIs replaced with text based labels and using
     * 'Only Labelled' option, only the resources and properties with
     * a label will be displayed.
     *
     * Rending a graph to an image will only work if you have the
     * GraphViz 'dot' command installed.
     *
     * @package    EasyRdf
     * @copyright  Copyright (c) 2012-2013 Nicholas J Humfrey
     * @license    http://unlicense.org/
     */

    set_include_path(get_include_path() . PATH_SEPARATOR . '../lib/');
    //require_once "EasyRdf.php"; // jevan 2018jan28
    require 'vendor/autoload.php'; // jevan 2018jan28
    require_once "../include/html_tag_helpers.php"; // jevan 2018jan28

    // jevan 2018jan28
    $format = "png";
    $image = 1;
    $ul = 1;
    $ol = 0;

    $formats = array(
      'PNG' => 'png',
      'GIF' => 'gif',
      'SVG' => 'svg'
    );

    $format = EasyRdf_Format::getFormat(
        isset($format) ? $format : 'png' // jevan 2018jan28
    );

    // Construct a graph of three people
    $graph = new EasyRdf_Graph();
    $graph->set('foaf:knows', 'rdfs:label', 'knows');
    $bob = $graph->resource('http://www.example.com/bob', 'foaf:Person');
    $alice = $graph->resource('http://www.example.com/alice', 'foaf:Person');
    $carol = $graph->resource('http://www.example.com/carol', 'foaf:Person');
    $bob->set('foaf:name', 'Bob');
    $alice->set('foaf:name', 'Alice');
    $carol->set('foaf:name', 'Carol');
    $bob->add('foaf:knows', $alice);
    $bob->add('foaf:knows', $carol);
    $alice->add('foaf:knows', $bob);
    $alice->add('foaf:knows', $carol);

    // Create a GraphViz serialiser
    $gv = new EasyRdf_Serialiser_GraphViz();
    $gv->setUseLabels($ul); // jevan 2018jan28
    $gv->setOnlyLabelled($ol); // jevan 2018jan28

    // If this is a request for the image, just render it and exit
    if (isset($image)) { // jevan 2018jan28
        header("Content-Type: ".$format->getDefaultMimeType());
        echo $gv->renderImage($graph, $format);
        exit;
    }
    // jevan 2018jan28
    print htmlspecialchars(
        $gv->serialise($graph, 'dot')
    );
?>
