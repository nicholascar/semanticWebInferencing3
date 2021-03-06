package de.fuberlin.wiwiss.ng4j.swp.vocabulary;

/* CVS $Id: SWP.java,v 1.5 2005/03/14 23:21:15 erw Exp $ */
 
import com.hp.hpl.jena.graph.Node;
 
/**
 * Vocabulary definitions from swp-3.rdf 
 * @author Auto-generated by schemagen on 11 Dec 2004 15:35 
 */
public class SWP 
{
    
    /** <p>The namespace of the vocabulary as a string</p> */
    public static final String NS = "http://www.w3.org/2004/03/trix/swp-2";
    
    /** <p>The namespace of the vocabulary as a string</p>
     *  @see #NS */
    public static String getURI() {return NS;}
    
    /** <p>The namespace of the vocabulary as a resource</p> */
    public static final Node NAMESPACE = Node.createURI( NS );
    
    /** <p>The object contains a digest value for the subject graph.</p> */
    public static final Node digest = Node.createURI( "http://www.w3.org/2004/03/trix/swp-2/digest" );
    
    /** <p>The object authority is the origin of the graph with which the subject warrant 
     *  is associated.</p>
     */
    public static final Node authority = Node.createURI( "http://www.w3.org/2004/03/trix/swp-2/authority" );
    
    /** <p>Defines a point in time after which the warrant is valid.</p> */
    public static final Node validFrom = Node.createURI( "http://www.w3.org/2004/03/trix/swp-2/validFrom" );
    
    /** <p>The object is the digest method by which the digest value specified for the 
     *  graph subject was constructed.</p>
     */
    public static final Node digestMethod = Node.createURI( "http://www.w3.org/2004/03/trix/swp-2/digestMethod" );
    
    /** <p>The object is the signature to be used to authenticate the graph with which 
     *  the subject warrant is associated.</p>
     */
    public static final Node signature = Node.createURI( "http://www.w3.org/2004/03/trix/swp-2/signature" );
    
    /** <p>Canonicalization method used by this signature or digest method.</p> */
    public static final Node canonicalizationAlgorithm = Node.createURI( "http://www.w3.org/2004/03/trix/swp-2/canonicalizationAlgorithm" );
    
    /** <p>The object is some kind of public key which belongs to the authority.</p> */
    public static final Node hasKey = Node.createURI( "http://www.w3.org/2004/03/trix/swp-2/hasKey" );
    
    /** <p>Signature algorithm used by this signature method.</p> */
    public static final Node signatureAlgorithm = Node.createURI( "http://www.w3.org/2004/03/trix/swp-2/signatureAlgorithm" );
    
    /** <p>The object is the signature method by which the signature specified for the 
     *  warrant subject was constructed.</p>
     */
    public static final Node signatureMethod = Node.createURI( "http://www.w3.org/2004/03/trix/swp-2/signatureMethod" );
    
    /** <p>Digest algorithm used by this digest method.</p> */
    public static final Node digestAlgorithm = Node.createURI( "http://www.w3.org/2004/03/trix/swp-2/digestAlgorithm" );
    
    /** <p>The object is a binary (ASN.1 DER) X.509 certificate containing the public 
     *  key of the authority. This property is similar to the xmldsig#rawX509Certificate 
     *  property. An alternative to the use of this property is to use swp:hasKey 
     *  together with swp:X509Certificate.</p>
     */
    public static final Node certificate = Node.createURI( "http://www.w3.org/2004/03/trix/swp-2/certificate" );
    
    public static final Node caCertificate = Node.createURI( "http://www.w3.org/2004/03/trix/swp-2/caCertificate" );
    
    /** <p>The subject graph originates from the authority specified for the object warrant. 
     *  The statements expressed in the graph are not taken to be claims made by that 
     *  authority, insofar as any statement using this property is concerned.</p>
     */
    public static final Node quotedBy = Node.createURI( "http://www.w3.org/2004/03/trix/swp-2/quotedBy" );
    
    /** <p>The object is the certification authority which issed the X509 certificate.</p> */
    public static final Node certificationAuthority = Node.createURI( "http://www.w3.org/2004/03/trix/swp-2/certificationAuthority" );
    
    /** <p>The subject graph originates from and is asserted by the authority specified 
     *  for the object warrant. The statements expressed in the graph are taken to 
     *  be claims made by that authority. This property has performative semantics.</p>
     */
    public static final Node assertedBy = Node.createURI( "http://www.w3.org/2004/03/trix/swp-2/assertedBy" );
    
    /** <p>The object is some kind of public key which can be used to validate the signature 
     *  attached to the warrant.</p>
     */
    public static final Node keyInfo = Node.createURI( "http://www.w3.org/2004/03/trix/swp-2/keyInfo" );
    
    /** <p>Defines a point in time until which the warrant is valid.</p> */
    public static final Node validUntil = Node.createURI( "http://www.w3.org/2004/03/trix/swp-2/validUntil" );
    
    /** <p>An algorithm to compute a hash digest from some data and to sign the digest.</p> */
    public static final Node SignatureAlgorithm = Node.createURI( "http://www.w3.org/2004/03/trix/swp-2/SignatureAlgorithm" );
    
    /** <p>A relationship between an authority and a graph, in which the authority is 
     *  in some way an origin of that graph. Warrants may include a digital signature 
     *  of the graph by the authority.</p>
     */
    public static final Node Warrant = Node.createURI( "http://www.w3.org/2004/03/trix/swp-2/Warrant" );
    
    /** <p>A RSA key as defined by XML-Signature in http://www.w3.org/TR/xmldsig-core/ 
     *  The XML-Signature Modulus and Exponent properties should be used to describe 
     *  the key.</p>
     */
    public static final Node RSAKey = Node.createURI( "http://www.w3.org/2004/03/trix/swp-2/RSAKey" );
    
    /** <p>A method used for creating a signature used to authenticate a graph. Signature 
     *  methods define an canonicalization method and a signature algorithm.</p>
     */
    public static final Node SignatureMethod = Node.createURI( "http://www.w3.org/2004/03/trix/swp-2/SignatureMethod" );
    
    /** <p>A DSA key as defined by XML-Signature in http://www.w3.org/TR/xmldsig-core/ 
     *  The XML-Signature P Q G Y J Seed and PgenCounter properties should be used 
     *  to describe the key.</p>
     */
    public static final Node DSAKey = Node.createURI( "http://www.w3.org/2004/03/trix/swp-2/DSAKey" );
    
    /** <p>A method used for computing a digest a graph. Digest method defines a canonicalization 
     *  alorithm and a digest algorithm.</p>
     */
    public static final Node DigestMethod = Node.createURI( "http://www.w3.org/2004/03/trix/swp-2/DigestMethod" );
    
    /** <p>A X509 certificate as defined by XML-Signature in http://www.w3.org/TR/xmldsig-core/ 
     *  The XML-Signature X509IssuerSerial X509SubjectName X509SKI X509Certificate 
     *  properties should be used to describe the certificate.</p>
     */
    public static final Node X509Certificate = Node.createURI( "http://www.w3.org/2004/03/trix/swp-2/X509Certificate" );
    
    /** <p>An authority which issues certificates.</p> */
    public static final Node CertificationAuthority = Node.createURI( "http://www.w3.org/2004/03/trix/swp-2/CertificationAuthority" );
    
    /** <p>A hash algorithm to compute a digest from some data.</p> */
    public static final Node DigestAlgorithm = Node.createURI( "http://www.w3.org/2004/03/trix/swp-2/DigestAlgorithm" );
    
    /** <p>Superclass of all classes representing cryptographic key information.</p> */
    public static final Node Key = Node.createURI( "http://www.w3.org/2004/03/trix/swp-2/Key" );
    
    /** <p>An authority, or origin, of a graph; such as a person or company.</p> */
    public static final Node Authority = Node.createURI( "http://www.w3.org/2004/03/trix/swp-2/Authority" );
    
    /** <p>An algorithm used to transform a graph to a canonical form.</p> */
    public static final Node CanonicalizationAlgorithm = Node.createURI( "http://www.w3.org/2004/03/trix/swp-2/CanonicalizationAlgorithm" );
    
    /** <p>A PGP key as defined by XML-Signature in http://www.w3.org/TR/xmldsig-core/ 
     *  The XML-Signature PGPKeyID and PGPKeyPacket properties should be used to describe 
     *  the key.</p>
     */
    public static final Node PGPKey = Node.createURI( "http://www.w3.org/2004/03/trix/swp-2/PGPKey" );
    
    /** <p>Jeremy's C14N method together with SHA1 and DSA</p> */
    public static final Node JjcRdfC14N_dsa_sha1 = Node.createURI( "http://www.w3.org/2004/03/trix/swp-2/JjcRdfC14N-dsa-sha1" );
	
	 /** <p>Jeremy's C14N method together with SHA224 and DSA</p> */
    public static final Node JjcRdfC14N_dsa_sha224 = Node.createURI( "http://www.w3.org/2004/03/trix/swp-2/JjcRdfC14N-dsa-sha224" );
	
	 /** <p>Jeremy's C14N method together with SHA256 and DSA</p> */
    public static final Node JjcRdfC14N_dsa_sha256 = Node.createURI( "http://www.w3.org/2004/03/trix/swp-2/JjcRdfC14N-dsa-sha256" );
	
	/** <p>Jeremy's C14N method together with SHA384 and DSA</p> */
    public static final Node JjcRdfC14N_dsa_sha384 = Node.createURI( "http://www.w3.org/2004/03/trix/swp-2/JjcRdfC14N-dsa-sha384" );
	
	 /** <p>Jeremy's C14N method together with SHA512 and DSA</p> */
    public static final Node JjcRdfC14N_dsa_sha512 = Node.createURI( "http://www.w3.org/2004/03/trix/swp-2/JjcRdfC14N-dsa-sha512" );
    
    /** <p>Jeremy's C14N method together with SHA1 and RSA</p> */
    public static final Node JjcRdfC14N_rsa_sha1 = Node.createURI( "http://www.w3.org/2004/03/trix/swp-2/JjcRdfC14N-rsa-sha1" );
	
	/** <p>Jeremy's C14N method together with SHA224 and RSA</p> */
    public static final Node JjcRdfC14N_rsa_sha224 = Node.createURI( "http://www.w3.org/2004/03/trix/swp-2/JjcRdfC14N-rsa-sha224" );
	
	/** <p>Jeremy's C14N method together with SHA256 and RSA</p> */
    public static final Node JjcRdfC14N_rsa_sha256 = Node.createURI( "http://www.w3.org/2004/03/trix/swp-2/JjcRdfC14N-rsa-sha256" );
	
	/** <p>Jeremy's C14N method together with SHA384 and RSA</p> */
    public static final Node JjcRdfC14N_rsa_sha384 = Node.createURI( "http://www.w3.org/2004/03/trix/swp-2/JjcRdfC14N-rsa-sha384" );
	
	/** <p>Jeremy's C14N method together with SHA512 and RSA</p> */
    public static final Node JjcRdfC14N_rsa_sha512 = Node.createURI( "http://www.w3.org/2004/03/trix/swp-2/JjcRdfC14N-rsa-sha512" );
    
    /** <p>Jeremy's C14N method together with SHA1</p> */
    public static final Node JjcRdfC14N_sha1 = Node.createURI( "http://www.w3.org/2004/03/trix/swp-2/JjcRdfC14N-sha1" );
	
	/** <p>Jeremy's C14N method together with SHA224</p> */
    public static final Node JjcRdfC14N_sha224 = Node.createURI( "http://www.w3.org/2004/03/trix/swp-2/JjcRdfC14N-sha224" );
	
	/** <p>Jeremy's C14N method together with SHA256</p> */
    public static final Node JjcRdfC14N_sha256 = Node.createURI( "http://www.w3.org/2004/03/trix/swp-2/JjcRdfC14N-sha256" );
	
	/** <p>Jeremy's C14N method together with SHA384</p> */
    public static final Node JjcRdfC14N_sha384 = Node.createURI( "http://www.w3.org/2004/03/trix/swp-2/JjcRdfC14N-sha384" );
	
	/** <p>Jeremy's C14N method together with SHA512</p> */
    public static final Node JjcRdfC14N_sha512 = Node.createURI( "http://www.w3.org/2004/03/trix/swp-2/JjcRdfC14N-sha512" );
    
    /** <p>Jeremy Carroll's RDF C14N method described in the 'Signing RDF Graphs' paper 
     *  http://www.hpl.hp.com/techreports/2003/HPL-2003-142.html</p>
     */
    public static final Node JjcRdfC14N = Node.createURI( "http://www.w3.org/2004/03/trix/swp-2/JjcRdfC14N" );
    
}
