# http://rdflib.readthedocs.io/en/stable/intro_to_sparql.html
import rdflib

g = rdflib.Graph()
g.parse("relatives.ttl", format="turtle")

qres = g.query("""
    PREFIX : <http://example.org/relatives#>
    SELECT * WHERE {
    ?s :hasChild ?o .
    }
""")

for row in qres:
    print("%s :hasChild %s" % row)
