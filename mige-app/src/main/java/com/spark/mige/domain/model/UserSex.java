package com.spark.mige.domain.model;

public enum UserSex {
	male("\u7537"), female("\u5973");
	
	private String name;
	
	private UserSex(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
