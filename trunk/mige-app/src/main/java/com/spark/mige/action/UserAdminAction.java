package com.spark.mige.action;

import java.util.List;

import com.spark.core.action.WebActionSupport;
import com.spark.mige.domain.entity.User;
import com.spark.mige.service.UserService;

public class UserAdminAction extends WebActionSupport {
	private static final long	serialVersionUID	= 1L;

	private List<User>			userList;

	public String listUser() {
		userList = getUserService().getAllUser();
		return SUCCESS;
	}

	private UserService getUserService() {
		return getBean(UserService.class, "userService");
	}
	
	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
}
