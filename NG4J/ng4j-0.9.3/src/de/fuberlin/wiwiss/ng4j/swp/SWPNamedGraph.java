package de.fuberlin.wiwiss.ng4j.swp;

import java.util.ArrayList;

import com.hp.hpl.jena.graph.Node;

import de.fuberlin.wiwiss.ng4j.NamedGraph;

/**
 * @author rowland watkins
 * @author chris bizer
 * @since 24-Nov-2004
 * 
 */
public interface SWPNamedGraph extends NamedGraph 
{
    /**
     * 
     * Given an SWP Authority, assert the current
     * graph with this Authority.
     * 
     * If the current graph is not a warrant graph, then
     * it will be turned into a warrant graph and the
     * warranting information will be added directly into the graph.
     *
     * Otherwise swpAssert will return false.
     * 
     * Example:
     * 
     * 		:G1 { :Monica foaf:name "Monica Murphy" }
     * 
     * would become:
     * 
     *		:G1 { :Monica foaf:name "Monica Murphy" .
     *			  :G1  swp:assertedBy :G1 .
     *			  :G1 swp:authority <http://www.bizer.de/me> }
     *
     * 
     * If the Authority doesn't have a URI, then a blank node will be used to
     * identify the authority and a additional triple containing the foaf:mbox
     * adress of the authority will be added.
     *
     * The listOfAuthorityProperties contains list of properties names
     * (as nodes) describing the authority. These properties will be included
     * into the warrant graph, e.g. foaf:name, foaf:mbox
     * 
     * @param authority
     */
    public boolean swpAssert( SWPAuthority authority, ArrayList<Node> listOfAuthorityProperties );

    public boolean swpAssert( SWPAuthority authority );

    /**
     * 
     * Given an SWP Authority, quote the current
     * graph with this Authority.
     *
     * @param authority
     */
    public boolean swpQuote( SWPAuthority authority, ArrayList<Node> listOfAuthorityProperties );

    public boolean swpQuote( SWPAuthority authority );
    
    /**
     * 
     * Given an SWP Authority, digitally sign the
     * current graph according to the signatureMethod.
     * 
     * The graph will be turned into a warrant graph and 
     * warranting and signature information will be added to the graph.
     * 
     * Example:
     * 
     * :G1 { :Monica foaf:name "Monica Murphy" .
     * 	     :G1 swp:assertedBy :G1 .
     *       :G1 swp:authority <http://www.bizer.de/me> 
     *       :G1 swp:signatureMethod swp:JjcRdfC14N-rsa-sha1 .
     *       :G1 swp:signature "..." }
     * 
     * If the graph is already a warrant graph, then a new warrant graph
     * will be created.
     * 
     * Example:
     * 
     * :G1 { :Monica foaf:name "Monica Murphy" .
     * 	     :G1 swp:assertedBy :G1 .
     *       :G1 swp:authority <http://www.MrX.net/me> 
     *       :G1 swp:signatureMethod swp:JjcRdfC14N-rsa-sha1 .
     *       :G1 swp:signature "..." }
     * 
     * :Timestamp { :G1 swp:assertedBy :Timestamp .
     *              :G1 swp:digestMethod swp:JjcRdfC14N-sha1 .
     *              :G1 swp:digest "..." .
	 *		        :Timestamp swp:assertedBy :Timestamp .
     *              :Timestamp swp:authority <http://www.bizer.de/me> .
     *              :Timestamp swp:signatureMethod swp:JjcRdfC14N-rsa-sha1 .
     *              :Timestamp swp:signature "..." } 
     *
     * The listOfAuthorityProperties contains list of properties names
     * (as nodes) describing the authority. These properties will be included
     * into the warrant graph, e.g. foaf:name, foaf:mbox, swp:publicKey
     * 
     * Return true if successful.
     * 
     * @param authority
     * @param signatureMethod
     * @return true if successful
     */
    public boolean assertWithSignature( SWPAuthority authority, Node signatureMethod, ArrayList<Node> listOfAuthorityProperties );

	// TODO: Change stuff below to iterators!

    /**
     * Returns an array of all warrants about the graph.
     * 
     */
    public SWPWarrant[] getWarrants();
    
    /**
     * Returns an array of all warrants with a verifiable signature about the graph.
     * 
     * Calling this method requires adding a graph called 
     * <http://localhost/trustedinformation> before.
     * This graph has to contain the public keys and 
     * certificates of authorities or root certificates by CAs
     * trusted by the user. The content of this graph will we
     * treated as trustworthy information in the signature 
     * verification process.
     * 
     * The results of the signature verification process will also be
     * added to the verification caching graph <http://localhost/verifiedSignatures> .
     * The content of the verification caching graph is also used to speed the verification
     * process.
     * 
     */
    public SWPWarrant[] getWarrantsWithVerifyableSignature();
    
    /**
     */
    public SWPAuthority[] getAssertingAuthorities();
    
    /**
     * 
     */
    public SWPAuthority[] getQuotingAuthorities();
    
    /**
     * 
     */
    public SWPAuthority[] getAssertingAuthoritiesWithVerifyableSignature();

}

/*
 *  (c)   Copyright 2004 - 2010 Chris Bizer (chris@bizer.de) & Rowland Watkins (rowland@grid.cx)
 *   	  All rights reserved. 
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. The name of the author may not be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 * THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */
