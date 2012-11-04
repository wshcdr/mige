package com.spark.mige.util;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.dom4j.Document;
import org.xml.sax.InputSource;

public abstract class DomUtils {
	
	public static org.w3c.dom.Document convert2DOMDocument(Document doc) throws Exception {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		InputSource source = new InputSource(new StringReader(doc.asXML()));
		return documentBuilder.parse(source);
	}
}
