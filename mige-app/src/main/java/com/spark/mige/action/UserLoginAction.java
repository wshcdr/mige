package com.spark.mige.action;

import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;

import com.opensymphony.xwork2.Preparable;
import com.spark.core.action.WebActionSupport;
import com.spark.core.util.AppUtils;
import com.spark.mige.domain.entity.User;
import com.spark.mige.domain.model.UserType;
import com.spark.mige.service.UserService;
import com.spark.mige.util.DomUtils;

public class UserLoginAction extends WebActionSupport implements Preparable {
	private static final long		serialVersionUID	= 1L;
	private final static String		USER_SESSION_NAME	= "user";

	private String					loginName;
	private String					sinaUserId;
	private String					sinaUserName;

	private org.w3c.dom.Document	feedbackDOM;

	/**
	 * login
	 * 
	 * @return
	 * @throws Exception
	 */
	public String login() throws Exception {
		User user = getUserService().getUserByLoginName(loginName);
		if (user == null) {
			feedbackDOM = createFailDocumnet();
		} else {
			session.put(USER_SESSION_NAME, user); // put user to session
			feedbackDOM = createUserInfoDOM(user);
		}
		return SUCCESS;
	}

	/**
	 * check if loginName has logined
	 * 
	 * @return
	 * @throws Exception
	 */
	public String checkLogin() throws Exception {
		User user = (User) session.get(USER_SESSION_NAME);
		if (user == null) {
			feedbackDOM = createFailDocumnet();
		} else {
			feedbackDOM = createUserInfoDOM(user);
		}
		return SUCCESS;
	}

	/**
	 * check sina account
	 * @return
	 * @throws Exception
	 */
	public String checkSinaAccount() throws Exception {
		User user = getUserService().getUserByLoginName(sinaUserId);
		feedbackDOM = createSinaAccountCheckDOM(user);
		return SUCCESS;
	}
	
	/**
	 * sina user login
	 * 
	 * @return
	 * @throws Exception
	 */
	public String sinaLogin() throws Exception {
		User user = getUserService().getUserByLoginName(sinaUserId);
		if (user == null) {
			user = createSinaUser();
		}
		feedbackDOM = createUserInfoDOM(user);
		return SUCCESS;
	}
	
	/**
	 * bind user
	 * @return
	 * @throws Exception 
	 */
	public String bindAccount() throws Exception {
		User sinaUser =  getUserService().getUserByLoginName(sinaUserId);
		User migeUser = getUserService().getUserByLoginName(loginName);
		if (sinaUser == null || migeUser == null) {
			feedbackDOM = createFailDocumnet();
		} else {
			getUserService().bindUser(sinaUser, migeUser);
			feedbackDOM = createUserInfoDOM(sinaUser);
		}
		return SUCCESS;
	}

	private User createSinaUser() {
		User user = new User();
		user.setLoginName(sinaUserId);
		user.setName(sinaUserName);
		user.setUserType(UserType.sina);
		user.setCreateTime(AppUtils.currentTime());
		user.setIsComplete(false);
		getUserService().create(user);
		return user;
	}

	@Override
	public void prepare() throws Exception {
		setResponseEncoding();
	}

	private org.w3c.dom.Document createUserInfoDOM(User user) throws Exception {
		Document doc = createDocument();
		Element root = doc.getRootElement();
		root.addElement("status").addText("success");
		root.addElement("user_id").addText(user.getId().toString());
		root.addElement("user_inf").addText(user.getIsComplete().toString());
		root.addElement("bind_status").addText(String.valueOf(user.getBindUser() != null));
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

	private org.w3c.dom.Document createSinaAccountCheckDOM(User user) throws Exception {
		Document doc = createDocument();
		Element root = doc.getRootElement();
		root.addElement("status").addText("success");
		if (user != null) {
			root.addElement("user_id").addText(user.getId().toString());
			root.addElement("user_inf").addText(user.getIsComplete().toString());
			root.addElement("bind_status").addText(String.valueOf(user.getBindUser() != null));
		} else {
			root.addElement("user_inf").addText("false");
			root.addElement("bind_status").addText("false");
		}
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

	public org.w3c.dom.Document getFeedbackDOM() {
		return feedbackDOM;
	}

	public void setFeedbackDOM(org.w3c.dom.Document feedbackDOM) {
		this.feedbackDOM = feedbackDOM;
	}

	public String getUser() {
		return loginName;
	}

	public void setUser(String user) {
		this.loginName = user;
	}

	public String getUser_name() {
		return sinaUserName;
	}

	public void setUser_name(String user_name) {
		this.sinaUserName = user_name;
	}

	public String getUser_id() {
		return sinaUserId;
	}

	public void setUser_id(String user_id) {
		this.sinaUserId = user_id;
	}
}
