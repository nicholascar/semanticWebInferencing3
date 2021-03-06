// $Id: UnionGraphTest.java,v 1.2 2009/02/11 15:15:05 jenpc Exp $
package de.fuberlin.wiwiss.ng4j;

import junit.framework.TestCase;

import com.hp.hpl.jena.graph.Graph;
import com.hp.hpl.jena.graph.Node;
import com.hp.hpl.jena.graph.Triple;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;

import de.fuberlin.wiwiss.ng4j.NamedGraphSet;
import de.fuberlin.wiwiss.ng4j.Quad;
import de.fuberlin.wiwiss.ng4j.impl.NamedGraphSetImpl;

/**
 * Unit tests for the {@link Graph} instance returned by
 * {@link NamedGraphSetImpl#asJenaGraph}.
 *
 * @author Richard Cyganiak (richard@cyganiak.de)
 */
public class UnionGraphTest extends TestCase {
	private final static Node node1 = Node.createURI("http://example.org/graph1");
	private final static Node node2 = Node.createURI("http://example.org/graph2");
	private final static Node foo = Node.createURI("http://example.org/#foo");
	private final static Node bar = Node.createURI("http://example.org/#bar");
	private final static Node baz = Node.createURI("http://example.org/#baz");

	private NamedGraphSet set;
	private Graph graph;

	protected void setUp() throws Exception {
		this.set = new NamedGraphSetImpl();
		this.graph = this.set.asJenaGraph(node1);
	}

	public void testFixture() {
		assertTrue(this.graph.isEmpty());
		assertEquals(0, this.graph.size());
	}

	public void testUpdateReflectedInOther() {
		this.set.addQuad(new Quad(node2, foo, bar, baz));
		assertTrue(this.graph.contains(foo, bar, baz));
		this.graph.add(new Triple(bar, baz, foo));
		assertTrue(this.set.containsQuad(new Quad(node1, bar, baz, foo)));
	}
	
	public void testRemoveDuplicateTriples() {
		this.set.addQuad(new Quad(node1, foo, bar, baz));
		this.set.addQuad(new Quad(node2, foo, bar, baz));
		ExtendedIterator it = this.graph.find(Node.ANY, Node.ANY, Node.ANY);
		assertTrue(it.hasNext());
		assertEquals(new Triple(foo, bar, baz), it.next());
		assertFalse(it.hasNext());
	}
	
	public void testDeleteDeletesFromAllNamedGraphs() {
		this.set.addQuad(new Quad(node1, foo, bar, baz));
		this.set.addQuad(new Quad(node2, foo, bar, baz));
		this.graph.delete(new Triple(foo, bar, baz));
		assertEquals(0, this.set.countQuads());
	}
}
