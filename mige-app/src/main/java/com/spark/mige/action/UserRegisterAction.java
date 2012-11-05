package com.spark.mige.action;

import java.text.ParseException;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;

import com.opensymphony.xwork2.Preparable;
import com.spark.core.action.WebActionSupport;
import com.spark.core.util.AppUtils;
import com.spark.mige.domain.entity.User;
import com.spark.mige.domain.model.UserSex;
import com.spark.mige.service.UserService;
import com.spark.mige.util.DomUtils;

public class UserRegisterAction extends WebActionSupport implements Preparable {
	private static final long		serialVersionUID	= 1L;

	/*
	 * register fields
	 */
	private String					account;
	private org.w3c.dom.Document	registerUserXmlDom;

	/*
	 * perfect info
	 */
	private Long					user_id;
	private String					name;
	private Integer					sex;
	private String					cb1;
	private String					cb2;
	private String					pos;
	private String					birthday;
	private String					tel;
	private String					address;
	private String					mail;
	private String					transportation;
	private String					fervourate;
	private String					verification;
	private org.w3c.dom.Document	perfectUserXmlDom;

	@Override
	public void prepare() throws Exception {
		setResponseEncoding();		
	}
	
	/**
	 * regist user
	 * 
	 * @return
	 * @throws Exception
	 */
	public String register() throws Exception {
		User user = newUser();
		getUserService().create(user);
		registerUserXmlDom = convert2Document(user);
		return SUCCESS;
	}

	/**
	 * perfect user info
	 * 
	 * @return
	 * @throws Exception
	 */
	public String perfectInfo() throws Exception {
		User user = getUserService().getUserById(user_id);
		if (user == null) {
			perfectUserXmlDom = createFailDocumnet();
			return SUCCESS;
		}
		fillUserInfo(user);
		user.setIsComplete(true);
		getUserService().merge(user);
		perfectUserXmlDom = convert2Document(user);
		return SUCCESS;
	}

	private User newUser() {
		User user = new User();
		user.setLoginName(account);
		user.setIsComplete(false);
		user.setCreateTime(AppUtils.currentTime());
		return user;
	}

	private void fillUserInfo(User user) throws ParseException {
		user.setName(name);
		user.setSex(UserSex.values()[sex]);
		user.setCountry(cb1);
		user.setCity(cb2);
		user.setPostCode(pos);
		user.setTelephone(tel);
		user.setAddress(address);
		user.setEmail(mail);
		if (StringUtils.isNotEmpty(birthday)) {
			user.setBirthday(AppUtils.parseDate(birthday, "yyyy-MM-dd"));
		}
		user.setTransportation(transportation);
		user.setFavorite(fervourate);
	}

	private org.w3c.dom.Document convert2Document(User user) throws Exception {
		Document doc = createDocument();
		Element root = doc.getRootElement();
		root.addElement("status").addText("success");
		if (!user.getIsComplete()) {
			root.addElement("user_id").addText(user.getId().toString());
		}
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

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public org.w3c.dom.Document getRegisterUserXmlDom() {
		return registerUserXmlDom;
	}

	public void setRegisterUserXmlDom(org.w3c.dom.Document registerUserXmlDom) {
		this.registerUserXmlDom = registerUserXmlDom;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getCb1() {
		return cb1;
	}

	public void setCb1(String cb1) {
		this.cb1 = cb1;
	}

	public String getCb2() {
		return cb2;
	}

	public void setCb2(String cb2) {
		this.cb2 = cb2;
	}

	public String getPos() {
		return pos;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTransportation() {
		return transportation;
	}

	public void setTransportation(String transportation) {
		this.transportation = transportation;
	}

	public String getFervourate() {
		return fervourate;
	}

	public void setFervourate(String fervourate) {
		this.fervourate = fervourate;
	}

	public String getVerification() {
		return verification;
	}

	public void setVerification(String verification) {
		this.verification = verification;
	}

	public org.w3c.dom.Document getPerfectUserXmlDom() {
		return perfectUserXmlDom;
	}

	public void setPerfectUserXmlDom(org.w3c.dom.Document perfectUserXmlDom) {
		this.perfectUserXmlDom = perfectUserXmlDom;
	}
}
