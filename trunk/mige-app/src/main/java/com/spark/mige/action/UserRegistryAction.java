package com.spark.mige.action;

import com.spark.core.action.WebActionSupport;

public class UserRegistryAction extends WebActionSupport {
	private static final long	serialVersionUID	= 1L;
	
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
