package com.spark.mige.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Element;

import com.spark.core.service.GenericServiceImpl;
import com.spark.core.util.AppUtils;
import com.spark.mige.dao.UserDao;
import com.spark.mige.domain.entity.User;
import com.spark.mige.service.UserService;

public class UserServiceImpl extends GenericServiceImpl implements UserService {
	private UserDao	userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User getUserById(Long id) {
		return userDao.getEntity(User.class, id);
	}

	@Override
	public User getUserByLoginName(String lname) {
		return userDao.getByLoginName(lname);
	}

	@Override
	public void addUserInfo(Element inf, User user) {
		addElement(inf, "name", user.getName());
		if (user.getSex() != null) {
			addElement(inf, "sex", user.getSex().getName());
		}
		addElement(inf, "cb1", user.getCountry());
		addElement(inf, "cb2", user.getCity());
		addElement(inf, "pos", user.getPostCode());
		addElement(inf, "address", user.getAddress());
		addElement(inf, "tel", user.getTelephone());
		if (user.getBirthday() != null) {
			addElement(inf, "birthday", AppUtils.format(user.getBirthday(), "yyyy-MM-dd"));
		}
		addElement(inf, "mail", user.getEmail());
		addElement(inf, "transportation", user.getTransportation());
		addElement(inf, "fervourate", user.getFavorite());
	}
	
	@Override
	public List<User> getAllUser() {
		return userDao.listAll();
	}
	
	private void addElement(Element e, String name, String val) {
		if (!StringUtils.isEmpty(val)) {
			e.addElement(name).addText(val);
		}
	}
}
