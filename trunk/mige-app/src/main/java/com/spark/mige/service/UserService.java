package com.spark.mige.service;

import java.util.List;

import org.dom4j.Element;

import com.spark.core.service.GenericService;
import com.spark.mige.domain.entity.User;

public interface UserService extends GenericService {

	/**
	 * get user by id
	 * 
	 * @param id
	 * @return
	 */
	User getUserById(Long id);

	/**
	 * get user by login name
	 * 
	 * @param lname
	 * @return
	 */
	User getUserByLoginName(String lname);

	/**
	 * add user info to Element
	 * 
	 * @param document
	 * @param user
	 * @return
	 */
	void addUserInfo(Element inf, User user);

	/**
	 * get all user
	 * @return
	 */
	List<User> getAllUser();
}
