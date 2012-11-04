package com.spark.mige.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import com.spark.core.dao.JpaDaoSupport;
import com.spark.mige.domain.entity.User;

public class UserDao extends JpaDaoSupport {

	public User getByLoginName(String lname) {
		String qlString = "select u from User u where u.loginName = :lname";
		TypedQuery<User> query = getEntityManager().createQuery(qlString, User.class);
		query.setParameter("lname", lname);
		query.setMaxResults(1);
		List<User> result = query.getResultList();
		if (result != null && !result.isEmpty()) {
			return result.get(0);
		} else {
			return null;
		}
	}
}
