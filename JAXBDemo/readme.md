###XML Terms
* Encoding - The text format of the XML documents. E.g. UTF-8, UTF-16
* Entity - Text that is ignored by XML processors. E.g. Smith &amp; Sons
* Processing Instructions - A instruction to XML processor. E.g. <?xml-sytlesheet type="text/xsl" href="style.xsl" ?>


###XML Processor types
1. **Tree-based Processor** : Represent entire XML document in form of object tree in memory.
    * Pros: Easy to search with XPath or API specific tools
    * Cons: More memory needed, slower than streaming
    * Example: DOM, JDom

1. **Streaming Processor** : Build or Parse XML one node at a time.
    * Divided into "Pull" or "Push" processor.
    * Push processor (e.g. SAX): It pushes the data into callback method that we design.
    * Pull processor (e.g. SaTX, XMLPullParser ): We look to data and only callback method that is meaning to us.
    * Pros: Fast and Memory Efficient
    * Cons: Becuase, complete data set is not stored in memory, XPath search not supported.
    * Also, SAX coding is complex.
    
1. **Binding-style Processor**
    * Works like DOM-style in background i.e. it also downloaded the XML into memory.
    * Developer annotes Java classes, runs simple code.
    * Pros: Efficient Programming Model, Easy to maintain
    * Cons: JAXB doesn't work in Android.
    * Exmaple: JAX-B, Simple 

####JAX-P (Java API for XML Processing)

	* JAX-P is the umbrella term which set standards for APIs included in Java SE.
	* It includes: 
	* DOM (Document Object Model) - (Read/Write Processor)
	* SAX - Simple API for XML  - (Event Based - Read Only Processor)
	* StAX - Streaming API for XML - (Event Based - Read/Write Processor)
	* TrAX - Transformation API for XML 
	
###JAX-B (Java Architecture For XML Binding)

Java APIs for Processing XML
1. DOM - Document Object Model (In-memory tree of nodes) - org.w3c.dom - Easy to use but doesn't scale well to large documents
1. SAX - Simple API for XML	- Event Based API - Push based - (callback methods) -  org.xml.sax - Cubersome to use but goes well with large document
1. StAX - Streaming API for XML - Event Based - Pull based - javax.xml.stream (XMLSteamWriter n XMLSteamReader..) - More convenient than SAX but still low-level
1. JAX-B - Java Architecture For XML Binding: Higher level API..works with XML schema file
     * Two Approaches 
          * Code First i.e. Java -> XSD
          * Schema First i.e. XSD -> Java


- Original XML Schema langague is DTD but it has limitation that it doesn't support namespaces and data types.
- Most widely used XML Schema langague is XSD (XML Schema Definition)


- Java JAX-B APIs are in javax.xml.bind package. 
- The entry point to the API is the class JAXBContext. (by calling factory method newInstance)
     * Java to XML = Marshalling 
		Using a javax.xml.bind.Marshaller
     * XML to Java = Un-marshalling
		Uusing a javax.xml.bind.Unmarshaller

		
- JAX-B API Best Practices
     * Reuse the JAXBContext object i.e. create JAXBContext only once in application and then reuse wherever needed.
     * JAXBContext is guaranteed to be 100% thread safe.
     * Do not reuse Marshaller and Unmarshaller as these are stateful and not thread safe. ALso, creation is cheap.

### xjc
* xjc is the JAXB binding complier.
* It takes an XML schema as input, and produces a Java package containing Java classes.

```java
 // Here, the classes for person.xsd will be produced in src/myxmlclasses package
 xjc -p src.myxmlclasses person.xsd
 
 
 //It generates following files in src/myxmlclasses directory
 // ObjectFactory.java - Factory methods, JaxB bound classes
 // package-info.java - A place for annotations that apply to all classes in a package
 // Person.java - Java represent of corresponding XSD 
 
```

###schemagen
schemagen is the JAXB Java-To-XMLSchema generator. It takes one or more java files as input and produces XML schemas.

```java
	schemagen src\model\Person.java
	
	//Produces schema1.xsd and src\model\Person.class
```

