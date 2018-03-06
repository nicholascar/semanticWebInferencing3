# http://ruby-rdf.github.io/sparql-client/
# http://www.rubydoc.info/github/ruby-rdf/rdf/RDF/URI
#
# Authors:
# Jevan Pipitone, Last Edit: 6 March 2018
#
require 'rubygems'
require 'sparql/client'
sparql = SPARQL::Client.new("http://127.0.0.1:3030/relativesTdbWithOwlInferencingAndOpenlletReasoner/query")
#result = sparql.query("SELECT * WHERE { ?s ?p ?o }")
result = sparql.query("PREFIX : <http://example.org/relatives#> SELECT ?gc ?gp WHERE { ?gc :hasGrandparent ?gp . ?gc a :Person . }")
#puts result.inspect   #=> true or false
puts "Number of solutions in results: " + result.each_solution.count.to_s
puts "" #blank line
result.each_solution do |solution|
  puts "gc (full URI): " + RDF::URI.normalize_path(solution.gc).inspect
  puts "gc (URI fragment): " + solution.gc.normalized_fragment.inspect
  puts "gp (full URI): " + RDF::URI.normalize_path(solution.gp).inspect
  puts "gp (URI fragment): " + solution.gp.normalized_fragment.inspect
  puts "Full solution item: " + solution.inspect
  puts "" #blank line
end
