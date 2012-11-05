package com.spark.mige.action;

import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;

import com.opensymphony.xwork2.Preparable;
import com.spark.core.action.WebActionSupport;
import com.spark.mige.domain.entity.User;
import com.spark.mige.service.UserService;
import com.spark.mige.util.DomUtils;

public class UserAction extends WebActionSupport implements Preparable {
	private static final long		serialVersionUID	= 1L;
	private final static String		USER_SESSION_NAME	= "user";

	private String					loginName;
	private org.w3c.dom.Document	loginFeedback;

	/**
	 * login
	 * 
	 * @return
	 * @throws Exception
	 */
	public String login() throws Exception {
		User user = getUserService().getUserByLoginName(loginName);
		if (user == null) {
			loginFeedback = createFailDocumnet();
		} else {
			session.put(USER_SESSION_NAME, user); // put user to session
			loginFeedback = generateFeedback(user);
		}
		return SUCCESS;
	}

	/**
	 * check if user has logined
	 * @return
	 * @throws Exception
	 */
	public String checkLogin() throws Exception {
		User user = (User) session.get(USER_SESSION_NAME);
		if (user == null) {
			loginFeedback = createFailDocumnet();
		} else {
			loginFeedback = generateFeedback(user);
		}
		return SUCCESS;
	}

	@Override
	public void prepare() throws Exception {
		setResponseEncoding();
	}

	private org.w3c.dom.Document generateFeedback(User user) throws Exception {
		Document doc = createDocument();
		Element root = doc.getRootElement();
		root.addElement("status").addText("success");
		root.addElement("user_id").addText(user.getId().toString());
		root.addElement("user_inf").addText(user.getIsComplete().toString());
		Element inf = root.addElement("inf");
		getUserService().addUserInfo(inf, user);

		return DomUtils.convert2DOMDocument(doc);
	}

	private org.w3c.dom.Document createFailDocumnet() throws Exception {
		Document doc = createDocument();
		Element root = doc.getRootElement();
		root.addElement("status").addText("fail");
		return DomUtils.convert2DOMDocument(doc);
	}

	private Document createDocument() {
		Document doc = DocumentFactory.getInstance().createDocument();
		doc.addElement("msg");
		return doc;
	}

	private UserService getUserService() {
		return getBean(UserService.class, "userService");
	}

	private void setResponseEncoding() {
		response.setContentType("text/xml;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
	}

	public org.w3c.dom.Document getLoginFeedback() {
		return loginFeedback;
	}

	public void setLoginFeedback(org.w3c.dom.Document loginFeedback) {
		this.loginFeedback = loginFeedback;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
}
