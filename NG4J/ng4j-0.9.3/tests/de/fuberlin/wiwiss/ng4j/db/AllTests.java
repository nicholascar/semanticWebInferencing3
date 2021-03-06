// $Id: AllTests.java,v 1.3 2009/01/21 01:37:39 jenpc Exp $
package de.fuberlin.wiwiss.ng4j.db;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Test suite for NamedGraphSetDB and its helper classes. Needs a MySQL database.
 * Connection data must be provided inside this file.
 *
 * TODO: Database access data shouldn't be here
 * 
 * @author Richard Cyganiak (richard@cyganiak.de)
 */
public class AllTests {

	public static void main(String[] args) {
		junit.textui.TestRunner.run(AllTests.suite());
	}

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for de.fuberlin.wiwiss.ng4j.db");
		//$JUnit-BEGIN$
		suite.addTestSuite(QuadDBTest.class);
//		suite.addTestSuite(TriQLAgainstDBTest.class);
		suite.addTestSuite(SPARQLAgainstDBTest.class);
		suite.addTestSuite(NamedGraphSetDBTest.class);
		//$JUnit-END$
		return suite;
	}
}
