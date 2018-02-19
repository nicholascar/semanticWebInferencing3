<?php
require_once( "inc/sparqllib.php" );

$endpoint = 'http://127.0.0.1:3030/relativesWithOwlInferencingAndOpenlletReasoner/query';
$query = 'PREFIX : <http://example.org/relatives#> ' .
'SELECT ?gc ?gp' .
' WHERE { ' .
'  ?gc :hasGrandparent ?gp . ' .
'  ?gc a :Person . ' .
'}';

$db = sparql_connect( $endpoint );
if( !$db ) { print sparql_errno() . ": " . sparql_error(). "\n"; exit; }

$result = sparql_query( $query );
if( !$result ) { print sparql_errno() . ": " . sparql_error(). "\n"; exit; }

$fields = sparql_field_array( $result );

print "<p>Number of rows: ".sparql_num_rows( $result )." results.</p>";
print "<table class='example_table'>";
print "<tr>";
foreach( $fields as $field )
{
	print "<th>$field</th>";
}
print "</tr>";
while( $row = sparql_fetch_array( $result ) )
{
	print "<tr>";
	foreach( $fields as $field )
	{
		print "<td>$row[$field]</td>";
	}
	print "</tr>";
}
print "</table>";

?>
