package com.spark.mige.action;

import javax.xml.parsers.ParserConfigurationException;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.dom.DOMDocumentFactory;

import com.spark.core.action.WebActionSupport;
import com.spark.mige.domain.entity.User;

public class UserLoginAction extends WebActionSupport {
	private static final long		serialVersionUID	= 1L;

	private String					userName;
	private org.w3c.dom.Document	userXmlData;

	public String login() throws ParserConfigurationException {
		User u = new User();
		u.setId(1l);
		u.setUserName("ghh");
		parseUser2Xml(u);
		return SUCCESS;
	}

	private void parseUser2Xml(User u) throws ParserConfigurationException {
		// DocumentBuilderFactory factory =
		// DocumentBuilderFactory.newInstance();
		// DocumentBuilder builder = factory.newDocumentBuilder();
		// Document doc = builder.newDocument();
		// Element root = doc.createElement("user");
		// doc.appendChild(root);
		// Element name = doc.createElement("name");
		// name.setTextContent(u.getUserName());
		// root.appendChild(name);
		// userXmlData = doc;
		Document doc = DOMDocumentFactory.getInstance().createDocument();
		Element root = doc.addElement("user");
		root.addElement("name").addText("ghh");
		userXmlData = (org.w3c.dom.Document) doc;
		System.out.println(doc.asXML());
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public org.w3c.dom.Document getUserXmlData() {
		return userXmlData;
	}

	public void setUserXmlData(org.w3c.dom.Document userXmlData) {
		this.userXmlData = userXmlData;
	}
}
