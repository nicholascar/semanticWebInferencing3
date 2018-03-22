Thu 22 mar 2018

https://protege.stanford.edu/
Protégé Desktop is a feature rich ontology editing environment with full support for the OWL 2 Web Ontology Language, and direct in-memory connections to description logic reasoners like HermiT and Pellet.

(name) Jevan Pipitone (e-mail) email2@jevan.com.au (Affiliation) (project url) https://github.com/jevanpipitone (Project Description) Presently testing reasoning systems in different programming languages against certain sparql queries

https://protege.stanford.edu/support.php
https://protegewiki.stanford.edu/wiki/Protege4UserDocs#Getting_started_.2F_tutorials
https://protegewiki.stanford.edu/wiki/Main_Page

https://protegewiki.stanford.edu/wiki/Protege4GettingStarted
Reasoning with your ontology is one of the most commonly performed activities and Protege comes with a built-in reasoner called HermiT. To classify your ontology, open the Reasoner menu and select HermiT, which will automatically classify your ontology.
There are other reasoners available for Protege, including Pellet and FaCT++. These reasoners are available for download from the File | Check for plugins... menu item

From protege:
(to add new useful plugins for my testing) File, Check for plugins
 tick boxes for:
  ELK: A Java-based OWL EL reasoner V0.4.3
  FaCT++ reasoner V1.6.5
  Pellet Reasoner Plug-in V2.2.0
  Snap SPARQL Query V5.0.0
  Protege SPARQL Plugin V2.0.2
 Install
(to update existing plugins) File, Check for plugins
 tick boxes for:
  OWLAPI RDF Library 2.0.3
  SWRLTab Protege 5.0+ Plugin V2.0.5
 Install

http://protege-project.136.n4.nabble.com/Noobie-question-td4664308.html
Consider Allegrograph, Ontotext, Virtuosso, Anzo/SparqlVerse, StarDog  they all support sparql on inferred triples. 

https://github.com/protegeproject/protege/issues/748
    Go to "File --> Check for Plug-ins"
    select the snap-sparql-query-plugin and make sure that OWLAPI RDF Library is up to date
    Go to Window --> Tabs and uncheck "SPARQL Query" (this might conflict with SNAP SPARQL - Protege froze when I clicked on the tab after installing SNAP and running the reasoner over an ontology so I turned it off)
    Restart Protege, load you ontology. The Snap Plugin is available as a View: Window > Views > Query Views > Snap SPARQL Query, which you can drop in any tab.
Some things found/done by Jevan about this:
- I found that unchecking "SPARQL Query" window under Window/Tabs, makes no difference to the query results made using "Snap SPARQL Query" - I tried Query2 using reasoner Pellet and None and got 7 results for both.
- I added the "Snap SPARQL Query" to the "SPARQL Query" tab so that I have both available for use.

----------------------------------------------------------------------

File Open, relatives.ttl

Reasoner, stop reasoner, ELK 0.4.3, start reasoner: get error message "ELK does not support InverseObjectProperties: Axiom ignored"
Reasoner, stop reasoner, FaCT++ 1.6.5, start reasoner
Reasoner, stop reasoner, HermiT 1.3.8.413, start reasoner
Reasoner, stop reasoner, Pellet, start reasoner
Reasoner, stop reasoner, Pellet (Incremental), start reasoner
Reasoner, stop reasoner, None

----------------------------------------------------------------------

Query1:
PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
PREFIX owl: <http://www.w3.org/2002/07/owl#>
PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>
PREFIX : <http://example.org/relatives#>
SELECT * WHERE { ?s :hasChild ?o . }

Reasoner FaCT++ 1.6.5, Paste in Query 1 to Snap SPARQL Query box, Execute
11 Results:
<http://example.org/relatives#Michael>	<http://example.org/relatives#Simon>	
<http://example.org/relatives#Cathy>	<http://example.org/relatives#Fred>	
<http://example.org/relatives#James2>	<http://example.org/relatives#John>	
<http://example.org/relatives#John>	<http://example.org/relatives#Michael>	
<http://example.org/relatives#John>	<http://example.org/relatives#Mary>	
<http://example.org/relatives#Fred>	<http://example.org/relatives#James>	
<http://example.org/relatives#Fred>	<http://example.org/relatives#Jacob>	
<http://example.org/relatives#Bill>	<http://example.org/relatives#Bob>	
<http://example.org/relatives#Bill>	<http://example.org/relatives#Cathy>	
<http://example.org/relatives#Simon>	<http://example.org/relatives#Tim>	
<http://example.org/relatives#Valerie>	<http://example.org/relatives#Tim>

Reasoner FaCT++ 1.6.5, Paste in Query 1 to SPARQL Query box, Execute
4 Results:
http://example.org/relatives#James2	http://example.org/relatives#John	
http://example.org/relatives#Fred	http://example.org/relatives#James	
http://example.org/relatives#John	http://example.org/relatives#Mary	
http://example.org/relatives#John	http://example.org/relatives#Michael

Reasoner HermiT 1.3.8.413, Paste in Query 1 to Snap SPARQL Query box, Execute
11 Results:
<http://example.org/relatives#Michael>	<http://example.org/relatives#Simon>	
<http://example.org/relatives#Cathy>	<http://example.org/relatives#Fred>	
<http://example.org/relatives#James2>	<http://example.org/relatives#John>	
<http://example.org/relatives#John>	<http://example.org/relatives#Michael>	
<http://example.org/relatives#John>	<http://example.org/relatives#Mary>	
<http://example.org/relatives#Fred>	<http://example.org/relatives#James>	
<http://example.org/relatives#Fred>	<http://example.org/relatives#Jacob>	
<http://example.org/relatives#Bill>	<http://example.org/relatives#Bob>	
<http://example.org/relatives#Bill>	<http://example.org/relatives#Cathy>	
<http://example.org/relatives#Simon>	<http://example.org/relatives#Tim>	
<http://example.org/relatives#Valerie>	<http://example.org/relatives#Tim>

Reasoner HermiT 1.3.8.413, Paste in Query 1 to SPARQL Query box, Execute
4 Results:
http://example.org/relatives#James2	http://example.org/relatives#John	
http://example.org/relatives#Fred	http://example.org/relatives#James	
http://example.org/relatives#John	http://example.org/relatives#Mary	
http://example.org/relatives#John	http://example.org/relatives#Michael

Reasoner Pellet, Paste in Query 1 to *Snap* SPARQL Query box, Execute
11 results
<http://example.org/relatives#Michael>	<http://example.org/relatives#Simon>	
<http://example.org/relatives#Cathy>	<http://example.org/relatives#Fred>	
<http://example.org/relatives#James2>	<http://example.org/relatives#John>	
<http://example.org/relatives#John>	<http://example.org/relatives#Michael>	
<http://example.org/relatives#John>	<http://example.org/relatives#Mary>	
<http://example.org/relatives#Fred>	<http://example.org/relatives#James>	
<http://example.org/relatives#Fred>	<http://example.org/relatives#Jacob>	
<http://example.org/relatives#Bill>	<http://example.org/relatives#Bob>	
<http://example.org/relatives#Bill>	<http://example.org/relatives#Cathy>	
<http://example.org/relatives#Simon>	<http://example.org/relatives#Tim>	
<http://example.org/relatives#Valerie>	<http://example.org/relatives#Tim>

Reasoner Pellet, Paste in Query 1 to SPARQL Query box, Execute
4 Results:
http://example.org/relatives#James2	http://example.org/relatives#John	
http://example.org/relatives#Fred	http://example.org/relatives#James	
http://example.org/relatives#John	http://example.org/relatives#Mary	
http://example.org/relatives#John	http://example.org/relatives#Michael

Reasoner Pellet (Incremental), Paste in Query 1 to *Snap* SPARQL Query box, Execute
11 Results:
<http://example.org/relatives#Michael>	<http://example.org/relatives#Simon>	
<http://example.org/relatives#Cathy>	<http://example.org/relatives#Fred>	
<http://example.org/relatives#James2>	<http://example.org/relatives#John>	
<http://example.org/relatives#John>	<http://example.org/relatives#Michael>	
<http://example.org/relatives#John>	<http://example.org/relatives#Mary>	
<http://example.org/relatives#Fred>	<http://example.org/relatives#James>	
<http://example.org/relatives#Fred>	<http://example.org/relatives#Jacob>	
<http://example.org/relatives#Bill>	<http://example.org/relatives#Bob>	
<http://example.org/relatives#Bill>	<http://example.org/relatives#Cathy>	
<http://example.org/relatives#Simon>	<http://example.org/relatives#Tim>	
<http://example.org/relatives#Valerie>	<http://example.org/relatives#Tim>

Reasoner Pellet (Incremental), Paste in Query 1 to SPARQL Query box, Execute
4 Results:
http://example.org/relatives#James2	http://example.org/relatives#John	
http://example.org/relatives#Fred	http://example.org/relatives#James	
http://example.org/relatives#John	http://example.org/relatives#Mary	
http://example.org/relatives#John	http://example.org/relatives#Michael

Reasoner None, Paste in Query 1 to *Snap* SPARQL Query box, Execute
11 Results:
<http://example.org/relatives#Michael>	<http://example.org/relatives#Simon>	
<http://example.org/relatives#Cathy>	<http://example.org/relatives#Fred>	
<http://example.org/relatives#James2>	<http://example.org/relatives#John>	
<http://example.org/relatives#John>	<http://example.org/relatives#Michael>	
<http://example.org/relatives#John>	<http://example.org/relatives#Mary>	
<http://example.org/relatives#Fred>	<http://example.org/relatives#James>	
<http://example.org/relatives#Fred>	<http://example.org/relatives#Jacob>	
<http://example.org/relatives#Bill>	<http://example.org/relatives#Bob>	
<http://example.org/relatives#Bill>	<http://example.org/relatives#Cathy>	
<http://example.org/relatives#Simon>	<http://example.org/relatives#Tim>	
<http://example.org/relatives#Valerie>	<http://example.org/relatives#Tim>

Reasoner None, Paste in Query 1 to SPARQL Query box, Execute
4 Results:
http://example.org/relatives#James2	http://example.org/relatives#John	
http://example.org/relatives#Fred	http://example.org/relatives#James	
http://example.org/relatives#John	http://example.org/relatives#Mary	
http://example.org/relatives#John	http://example.org/relatives#Michael

----------------------------------------------------------------------

Query2:
PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
PREFIX owl: <http://www.w3.org/2002/07/owl#>
PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>
PREFIX : <http://example.org/relatives#>
SELECT ?gp WHERE { ?gc :hasGrandparent ?gp . ?gc a :Person . }

Reasoner FaCT++ 1.6.5, Paste in Query 2 to *Snap* SPARQL Query box, Execute
7 Results:
<http://example.org/relatives#Cathy>	
<http://example.org/relatives#Cathy>	
<http://example.org/relatives#James2>	
<http://example.org/relatives#James2>	
<http://example.org/relatives#John>	
<http://example.org/relatives#Michael>	
<http://example.org/relatives#Bill>

Reasoner FaCT++ 1.6.5, Paste in Query 2 to SPARQL Query box, Execute
0 Results

Reasoner HermiT 1.3.8.413, Paste in Query 2 to *Snap* SPARQL Query box, Execute
7 Results:
<http://example.org/relatives#Cathy>	
<http://example.org/relatives#Cathy>	
<http://example.org/relatives#James2>	
<http://example.org/relatives#James2>	
<http://example.org/relatives#John>	
<http://example.org/relatives#Michael>	
<http://example.org/relatives#Bill>

Reasoner HermiT 1.3.8.413, Paste in Query 2 to SPARQL Query box, Execute
0 Results

Reasoner Pellet, Paste in Query 2 to *Snap* SPARQL Query box, Execute
7 Results:
<http://example.org/relatives#Cathy>	
<http://example.org/relatives#Cathy>	
<http://example.org/relatives#James2>	
<http://example.org/relatives#James2>	
<http://example.org/relatives#John>	
<http://example.org/relatives#Michael>	
<http://example.org/relatives#Bill>

Reasoner Pellet, Paste in Query 2 to SPARQL Query box, Execute
0 Results

Reasoner Pellet (Incremental), Paste in Query 2 to *Snap* SPARQL Query box, Execute
7 Results:
<http://example.org/relatives#Cathy>	
<http://example.org/relatives#James2>	
<http://example.org/relatives#Cathy>	
<http://example.org/relatives#James2>	
<http://example.org/relatives#John>	
<http://example.org/relatives#Michael>	
<http://example.org/relatives#Bill>

Reasoner Pellet (Incremental), Paste in Query 2 to SPARQL Query box, Execute
0 Results

Reasoner None, Paste in Query 2 to *Snap* SPARQL Query box, Execute
7 Results:
<http://example.org/relatives#Cathy>	
<http://example.org/relatives#James2>	
<http://example.org/relatives#Cathy>	
<http://example.org/relatives#James2>	
<http://example.org/relatives#John>	
<http://example.org/relatives#Michael>	
<http://example.org/relatives#Bill>

Reasoner None, Paste in Query 2 to SPARQL Query box, Execute
0 Results

----------------------------------------------------------------------
Messages when starting a reasoner:

1. ELK 0.4.3

------------------------------- Running Reasoner -------------------------------
ELK reasoner was created
Pre-computing inferences:
    - class hierarchy
    - object property hierarchy
    - data property hierarchy
    - class assertions
    - object property assertions
    - same individuals
Loading of Axioms started
Loading of Axioms using 4 workers
[reasoner.indexing.axiomIgnored]ELK does not support InverseObjectProperties. Axiom ignored:
InverseObjectProperties(<http://example.org/relatives#hasChild> <http://example.org/relatives#hasParent>)
Loading of Axioms took 24 ms
Property Saturation Initialization started
Property Saturation Initialization using 4 workers
Property Saturation Initialization took 8 ms
Reflexive Property Computation started
Reflexive Property Computation using 4 workers
Reflexive Property Computation took 25 ms
Object Property Hierarchy and Composition Computation started
Object Property Hierarchy and Composition Computation using 4 workers
Object Property Hierarchy and Composition Computation took 19 ms
Context Initialization started
Context Initialization using 4 workers
Context Initialization took 5 ms
Consistency Checking started
Consistency Checking using 4 workers
Consistency Checking took 18 ms
Class Taxonomy Computation started
Class Taxonomy Computation using 4 workers
Class Taxonomy Computation took 23 ms
Instance Taxonomy Computation started
Instance Taxonomy Computation using 4 workers
Instance Taxonomy Computation took 16 ms
Ontologies processed in 316 ms by ELK Reasoner

2. FaCT++ 1.6.5

------------------------------- Running Reasoner -------------------------------
FaCT++.Kernel: Reasoner for the SROIQ(D) Description Logic, 64-bit
Copyright (C) Dmitry Tsarkov, 2002-2016. Version 1.6.5 (31 December 2016)
Pre-computing inferences:
    - class hierarchy
    - object property hierarchy
    - data property hierarchy
    - class assertions
    - object property assertions
    - same individuals
Ontologies processed in 47 ms by FaCT++

3. HermiT 1.3.8.413

------------------------------- Running Reasoner -------------------------------
Pre-computing inferences:
    - class hierarchy
    - object property hierarchy
    - data property hierarchy
    - class assertions
    - object property assertions
    - same individuals
Ontologies processed in 122 ms by null

4. Pellet

------------------------------- Running Reasoner -------------------------------
Pre-computing inferences:
    - class hierarchy
    - object property hierarchy
    - data property hierarchy
    - class assertions
    - object property assertions
    - same individuals
Ontologies processed in 29 ms by Pellet

5. Pellet (Incremental)

------------------------------- Running Reasoner -------------------------------
Pre-computing inferences:
    - class hierarchy
    - object property hierarchy
    - data property hierarchy
    - class assertions
    - object property assertions
    - same individuals
Uncaught Exception in thread 'partitioning'
java.lang.NoSuchMethodError: org.semanticweb.owlapi.util.OWLEntityCollector.setCollectDatatypes(Z)V
        at com.clarkparsia.owlapiv3.OntologyUtils.getSignature(OntologyUtils.java:71) ~[na:na]
        at com.clarkparsia.modularity.AbstractModuleExtractor.processAdditions(AbstractModuleExtractor.java:419) ~[na:na]
        at com.clarkparsia.modularity.AbstractModuleExtractor.extractModules(AbstractModuleExtractor.java:188) ~[na:na]
        at com.clarkparsia.modularity.IncrementalClassifier$2.run(IncrementalClassifier.java:507) ~[na:na]
Ontologies processed in 30 ms by Pellet (Incremental)

----------------------------------------------------------------------

Discussion by Jevan:

- All reasoners including NONE for Query 1 to *Snap* SPARQL Query box
produce the same 11 results
- All reasoners including NONE for Query 1 to SPARQL Query box
produce the same 4 results
- All reasoners including NONE for Query 2 to *Snap* SPARQL Query box
produce the same 7 results
- All reasoners including NONE for Query 2 to SPARQL Query box
produce the same 0 results

It appears that selection and starting of a reasoner has no effect
to the results of query using the "Snap SPARQL Query" box,
or query using the "SPARQL Query box".

----------------------------------------------------------------------

Query 1 using "SPARQL Query" tab containing "SPARQL query"/"Snap SPARQL Query" windows:
Close "SPARQL Query" tab
Select reasoner: ELK 0.4.3
Start reasoner
Window, tabs, SPARQL Query
click on "SPARQL Query" tab, paste in Query 1
Execute
Results (SPARQL query window): 4 Results (no error)
http://example.org/relatives#James2	http://example.org/relatives#John	
http://example.org/relatives#Fred	http://example.org/relatives#James	
http://example.org/relatives#John	http://example.org/relatives#Mary	
http://example.org/relatives#John	http://example.org/relatives#Michael
Results (Snap SPARQL Query window): (no result occurred as an error occurred)
------------------------------- Running Reasoner -------------------------------
ELK reasoner was created
Pre-computing inferences:
    - class hierarchy
    - object property hierarchy
    - data property hierarchy
    - class assertions
    - object property assertions
    - same individuals
Loading of Axioms started
Loading of Axioms using 4 workers
[reasoner.indexing.axiomIgnored]ELK does not support InverseObjectProperties. Axiom ignored:
InverseObjectProperties(<http://example.org/relatives#hasChild> <http://example.org/relatives#hasParent>)
Loading of Axioms took 1 ms
Property Saturation Initialization started
Property Saturation Initialization using 4 workers
Property Saturation Initialization took 0 ms
Reflexive Property Computation started
Reflexive Property Computation using 4 workers
Reflexive Property Computation took 0 ms
Object Property Hierarchy and Composition Computation started
Object Property Hierarchy and Composition Computation using 4 workers
Object Property Hierarchy and Composition Computation took 0 ms
Context Initialization started
Context Initialization using 4 workers
Context Initialization took 0 ms
Consistency Checking started
Consistency Checking using 4 workers
Consistency Checking took 0 ms
Class Taxonomy Computation started
Class Taxonomy Computation using 4 workers
Class Taxonomy Computation took 2 ms
Instance Taxonomy Computation started
Instance Taxonomy Computation using 4 workers
Instance Taxonomy Computation took 3 ms
Ontologies processed in 15 ms by ELK Reasoner
[owlapi.unsupportedMethod]OWL API reasoner method is not implemented: getObjectPropertyValues(OWLNamedIndividual, OWLObjectPropertyExpression).

Query 1 using "SPARQL Query" tab containing "SPARQL query"/"Snap SPARQL Query" windows:
Close "SPARQL Query" tab
Select reasoner: FaCT++ 1.6.5
Start reasoner
Window, tabs, SPARQL Query
click on "SPARQL Query" tab, paste in Query 1
Execute
Results (SPARQL query window): 4 Results
http://example.org/relatives#James2	http://example.org/relatives#John	
http://example.org/relatives#Fred	http://example.org/relatives#James	
http://example.org/relatives#John	http://example.org/relatives#Mary	
http://example.org/relatives#John	http://example.org/relatives#Michael
Results (Snap SPARQL Query window): 11 results
<http://example.org/relatives#Michael>	<http://example.org/relatives#Simon>	
<http://example.org/relatives#Cathy>	<http://example.org/relatives#Fred>	
<http://example.org/relatives#James2>	<http://example.org/relatives#John>	
<http://example.org/relatives#John>	<http://example.org/relatives#Michael>	
<http://example.org/relatives#John>	<http://example.org/relatives#Mary>	
<http://example.org/relatives#Fred>	<http://example.org/relatives#James>	
<http://example.org/relatives#Fred>	<http://example.org/relatives#Jacob>	
<http://example.org/relatives#Bill>	<http://example.org/relatives#Bob>	
<http://example.org/relatives#Bill>	<http://example.org/relatives#Cathy>	
<http://example.org/relatives#Simon>	<http://example.org/relatives#Tim>	
<http://example.org/relatives#Valerie>	<http://example.org/relatives#Tim>

Query 1 using "SPARQL Query" tab containing "SPARQL query"/"Snap SPARQL Query" windows:
Close "SPARQL Query" tab
Select reasoner: HermiT 1.3.8.413
Start reasoner
Window, tabs, SPARQL Query
click on "SPARQL Query" tab, paste in Query 1
Execute
Results (SPARQL query window): 4 Results
http://example.org/relatives#James2	http://example.org/relatives#John	
http://example.org/relatives#Fred	http://example.org/relatives#James	
http://example.org/relatives#John	http://example.org/relatives#Mary	
http://example.org/relatives#John	http://example.org/relatives#Michael
Results (Snap SPARQL Query window): 11 results
<http://example.org/relatives#Michael>	<http://example.org/relatives#Simon>	
<http://example.org/relatives#Cathy>	<http://example.org/relatives#Fred>	
<http://example.org/relatives#James2>	<http://example.org/relatives#John>	
<http://example.org/relatives#John>	<http://example.org/relatives#Michael>	
<http://example.org/relatives#John>	<http://example.org/relatives#Mary>	
<http://example.org/relatives#Fred>	<http://example.org/relatives#James>	
<http://example.org/relatives#Fred>	<http://example.org/relatives#Jacob>	
<http://example.org/relatives#Bill>	<http://example.org/relatives#Bob>	
<http://example.org/relatives#Bill>	<http://example.org/relatives#Cathy>	
<http://example.org/relatives#Simon>	<http://example.org/relatives#Tim>	
<http://example.org/relatives#Valerie>	<http://example.org/relatives#Tim>

Query 1 using "SPARQL Query" tab containing "SPARQL query"/"Snap SPARQL Query" windows:
Close "SPARQL Query" tab
Select reasoner: Pellet
Start reasoner
Window, tabs, SPARQL Query
click on "SPARQL Query" tab, paste in Query 1
Execute
Results (SPARQL query window): 4 Results
http://example.org/relatives#James2	http://example.org/relatives#John	
http://example.org/relatives#Fred	http://example.org/relatives#James	
http://example.org/relatives#John	http://example.org/relatives#Mary	
http://example.org/relatives#John	http://example.org/relatives#Michael
Results (Snap SPARQL Query window): 11 results
<http://example.org/relatives#Michael>	<http://example.org/relatives#Simon>	
<http://example.org/relatives#Cathy>	<http://example.org/relatives#Fred>	
<http://example.org/relatives#James2>	<http://example.org/relatives#John>	
<http://example.org/relatives#John>	<http://example.org/relatives#Michael>	
<http://example.org/relatives#John>	<http://example.org/relatives#Mary>	
<http://example.org/relatives#Fred>	<http://example.org/relatives#James>	
<http://example.org/relatives#Fred>	<http://example.org/relatives#Jacob>	
<http://example.org/relatives#Bill>	<http://example.org/relatives#Bob>	
<http://example.org/relatives#Bill>	<http://example.org/relatives#Cathy>	
<http://example.org/relatives#Simon>	<http://example.org/relatives#Tim>	
<http://example.org/relatives#Valerie>	<http://example.org/relatives#Tim>

I tried the above query1 for "Pellet" with "SPARQL query" plugin window
in "SPARQL Query" tab and "Snap SPARQL Query" plugin window closed,
and got the same result. So it appears that closing the
"Snap SPARQL Query" plugin window has no effect on the results
for the "SPARQL Query" plugin since there are still 4 results,
not the wanted 11 results.

Query 1 using "SPARQL Query" tab containing "SPARQL query"/"Snap SPARQL Query" windows:
Close "SPARQL Query" tab
Select reasoner: Pellet (Incremental)
Start reasoner
Window, tabs, SPARQL Query
click on "SPARQL Query" tab, paste in Query 1
Execute
Results (SPARQL query window): 4 Results
http://example.org/relatives#James2	http://example.org/relatives#John	
http://example.org/relatives#Fred	http://example.org/relatives#James	
http://example.org/relatives#John	http://example.org/relatives#Mary	
http://example.org/relatives#John	http://example.org/relatives#Michael
Results (Snap SPARQL Query window): 11 results
<http://example.org/relatives#Michael>	<http://example.org/relatives#Simon>	
<http://example.org/relatives#Cathy>	<http://example.org/relatives#Fred>	
<http://example.org/relatives#James2>	<http://example.org/relatives#John>	
<http://example.org/relatives#John>	<http://example.org/relatives#Michael>	
<http://example.org/relatives#John>	<http://example.org/relatives#Mary>	
<http://example.org/relatives#Fred>	<http://example.org/relatives#James>	
<http://example.org/relatives#Fred>	<http://example.org/relatives#Jacob>	
<http://example.org/relatives#Bill>	<http://example.org/relatives#Bob>	
<http://example.org/relatives#Bill>	<http://example.org/relatives#Cathy>	
<http://example.org/relatives#Simon>	<http://example.org/relatives#Tim>	
<http://example.org/relatives#Valerie>	<http://example.org/relatives#Tim>

Query 1 using "SPARQL Query" tab containing "SPARQL query"/"Snap SPARQL Query" windows:
Close "SPARQL Query" tab
Select reasoner: None
Start reasoner
Window, tabs, SPARQL Query
click on "SPARQL Query" tab, paste in Query 1
Execute
Results (SPARQL query window): 4 Results
http://example.org/relatives#James2	http://example.org/relatives#John	
http://example.org/relatives#Fred	http://example.org/relatives#James	
http://example.org/relatives#John	http://example.org/relatives#Mary	
http://example.org/relatives#John	http://example.org/relatives#Michael
Results (Snap SPARQL Query window): 4 results
<http://example.org/relatives#James2>	<http://example.org/relatives#John>	
<http://example.org/relatives#John>	<http://example.org/relatives#Michael>	
<http://example.org/relatives#John>	<http://example.org/relatives#Mary>	
<http://example.org/relatives#Fred>	<http://example.org/relatives#James>

----------------------------------------------------------------------

Query 2 using "SPARQL Query" tab containing "SPARQL query"/"Snap SPARQL Query" windows:
Close "SPARQL Query" tab
Select reasoner: ELK 0.4.3
Start reasoner
Window, tabs, SPARQL Query
click on "SPARQL Query" tab, paste in Query 2
Execute
Results (SPARQL query window): 0 Results (no error)
Results (Snap SPARQL Query window): (no result occurred as an error occurred)
------------------------------- Running Reasoner -------------------------------
ELK reasoner was created
Pre-computing inferences:
    - class hierarchy
    - object property hierarchy
    - data property hierarchy
    - class assertions
    - object property assertions
    - same individuals
Loading of Axioms started
Loading of Axioms using 4 workers
[reasoner.indexing.axiomIgnored]ELK does not support InverseObjectProperties. Axiom ignored:
InverseObjectProperties(<http://example.org/relatives#hasChild> <http://example.org/relatives#hasParent>)
Loading of Axioms took 3 ms
Property Saturation Initialization started
Property Saturation Initialization using 4 workers
Property Saturation Initialization took 3 ms
Reflexive Property Computation started
Reflexive Property Computation using 4 workers
Reflexive Property Computation took 4 ms
Object Property Hierarchy and Composition Computation started
Object Property Hierarchy and Composition Computation using 4 workers
Object Property Hierarchy and Composition Computation took 3 ms
Context Initialization started
Context Initialization using 4 workers
Context Initialization took 0 ms
Consistency Checking started
Consistency Checking using 4 workers
Consistency Checking took 6 ms
Class Taxonomy Computation started
Class Taxonomy Computation using 4 workers
Class Taxonomy Computation took 5 ms
Instance Taxonomy Computation started
Instance Taxonomy Computation using 4 workers
Instance Taxonomy Computation took 13 ms
Ontologies processed in 106 ms by ELK Reasoner
[owlapi.unsupportedMethod]OWL API reasoner method is not implemented: getObjectPropertyValues(OWLNamedIndividual, OWLObjectPropertyExpression).

Query 2 using "SPARQL Query" tab containing "SPARQL query"/"Snap SPARQL Query" windows:
Close "SPARQL Query" tab
Select reasoner: FaCT++ 1.6.5
Start reasoner
Window, tabs, SPARQL Query
click on "SPARQL Query" tab, paste in Query 2
Execute
Results (SPARQL query window): 0 Results
Results (Snap SPARQL Query window): 7 results
<http://example.org/relatives#Cathy>	
<http://example.org/relatives#Cathy>	
<http://example.org/relatives#James2>	
<http://example.org/relatives#James2>	
<http://example.org/relatives#John>	
<http://example.org/relatives#Michael>	
<http://example.org/relatives#Bill>

Query 2 using "SPARQL Query" tab containing "SPARQL query"/"Snap SPARQL Query" windows:
Close "SPARQL Query" tab
Select reasoner: HermiT 1.3.8.413
Start reasoner
Window, tabs, SPARQL Query
click on "SPARQL Query" tab, paste in Query 2
Execute
Results (SPARQL query window): 0 Results
Results (Snap SPARQL Query window): 7 results
<http://example.org/relatives#Cathy>	
<http://example.org/relatives#Cathy>	
<http://example.org/relatives#James2>	
<http://example.org/relatives#James2>	
<http://example.org/relatives#John>	
<http://example.org/relatives#Michael>	
<http://example.org/relatives#Bill>

Query 2 using "SPARQL Query" tab containing "SPARQL query"/"Snap SPARQL Query" windows:
Close "SPARQL Query" tab
Select reasoner: Pellet
Start reasoner
Window, tabs, SPARQL Query
click on "SPARQL Query" tab, paste in Query 2
Execute
Results (SPARQL query window): 0 Results
Results (Snap SPARQL Query window): 7 results
<http://example.org/relatives#Cathy>	
<http://example.org/relatives#James2>	
<http://example.org/relatives#Cathy>	
<http://example.org/relatives#James2>	
<http://example.org/relatives#John>	
<http://example.org/relatives#Michael>	
<http://example.org/relatives#Bill>

Query 2 using "SPARQL Query" tab containing "SPARQL query"/"Snap SPARQL Query" windows:
Close "SPARQL Query" tab
Select reasoner: Pellet (Incremental)
Start reasoner
Window, tabs, SPARQL Query
click on "SPARQL Query" tab, paste in Query 2
Execute
Results (SPARQL query window): 0 Results
Results (Snap SPARQL Query window): 7 results
<http://example.org/relatives#Cathy>	
<http://example.org/relatives#James2>	
<http://example.org/relatives#Cathy>	
<http://example.org/relatives#James2>	
<http://example.org/relatives#John>	
<http://example.org/relatives#Michael>	
<http://example.org/relatives#Bill>

Query 2 using "SPARQL Query" tab containing "SPARQL query"/"Snap SPARQL Query" windows:
Close "SPARQL Query" tab
Select reasoner: None
Start reasoner
Window, tabs, SPARQL Query
click on "SPARQL Query" tab, paste in Query 2
Execute
Results (SPARQL query window): 0 Results
Results (Snap SPARQL Query window): 0 results

----------------------------------------------------------------------

Discussion by Jevan:

1. Query 1 using "SPARQL Query" tab containing "SPARQL query"/"Snap SPARQL Query" windows:

Query1 for reasoners FaCT++ 1.6.5, HermiT 1.3.8.413, Pellet, Pellet (Incremental)
gives 4 results for "SPARQL query window" plugin, and
11 results for "Snap SPARQL Query window" plugin.

Query1 for reasoners None
gives 4 results for "SPARQL query window" plugin, and
4 results for "Snap SPARQL Query window" plugin

Starting reasoner "ELK 0.4.3" gives an error message;
Query1 for reasoners ELK 0.4.3
gives 4 results for "SPARQL query window" plugin (no error)
and gives an error message for "Snap SPARQL Query window" plugin.

2. Query 2 using "SPARQL Query" tab containing "SPARQL query"/"Snap SPARQL Query" windows:

Query2 for reasoners FaCT++ 1.6.5, HermiT 1.3.8.413, Pellet, Pellet (Incremental)
gives 0 results for "SPARQL query window" plugin, and
7 results for "Snap SPARQL Query window" plugin.

Query2 for reasoners None
gives 0 results for "SPARQL query window" plugin, and
0 results for "Snap SPARQL Query window" plugin

Starting reasoner "ELK 0.4.3" gives an error message;
Query2 for reasoners ELK 0.4.3
gives 0 results for "SPARQL query window" plugin (no error)
and gives an error message for "Snap SPARQL Query window" plugin.

Therefore it is seen that it is essential to close the "SPARQL Query"
tab prior to stopping, selecting and starting a reasoner, then reopen
the "SPARQL Query" tab (Window, Tabs, SPARQL Query) paste in the query
into both windows (SPARQL query, and Snap SPARQL query) and execute both.
If the tab is not closed prior to starting a new reasoner, it does not
use the new reasoner; I am unsure what it is actually doing in that
situation, however I think that it is using the last selected
reasoner still.

----------------------------------------------------------------------

Text of findings as at 2018mar22 for INFERENCING_STACKS.md

Closing "SPARQL query" tab prior to choosing and starting another reasoner. Query1 for reasoners FaCT++ 1.6.5, HermiT 1.3.8.413, Pellet, Pellet (Incremental): 11 results for Snap SPARQL Query plugin, 4 results for SPARQL query window plugin. Query1 for reasoner None: 4 results for Snap SPARQL Query plugin, 4 results for SPARQL query window plugin. Query1 for reasoner ELK 0.4.3: error for Snap SPARQL Query plugin, 4 results for SPARQL query window plugin. Query2 for reasoners FaCT++ 1.6.5, HermiT 1.3.8.413, Pellet, Pellet (Incremental): 7 results for Snap SPARQL Query plugin, 0 results for SPARQL query window plugin. Query2 for reasoner None: 0 results for Snap SPARQL Query plugin, 0 results for SPARQL query window plugin. Query2 for reasoner ELK 0.4.3: error for Snap SPARQL Query plugin, 0 results for SPARQL query window plugin. In summary what works 100% is Query1 for reasoners FaCT++ 1.6.5, HermiT 1.3.8.413, Pellet, Pellet (Incremental) for Snap SPARQL Query plugin, Query2 for reasoners FaCT++ 1.6.5, HermiT 1.3.8.413, Pellet, Pellet (Incremental) for Snap SPARQL Query plugin.

----------------------------------------------------------------------

