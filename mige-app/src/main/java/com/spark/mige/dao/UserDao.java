package com.spark.mige.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import com.spark.core.dao.JpaDaoSupport;
import com.spark.mige.domain.entity.User;

public class UserDao extends JpaDaoSupport {
	
	public boolean isExist(String lname) {
		String qlString = "select count(u) from User u where u.loginName = :lname";
		TypedQuery<Integer> query = getEntityManager().createQuery(qlString, Integer.class);
		query.setParameter("lname", lname);
		return query.getSingleResult() > 0;
	}
	
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
	
	public List<User> listAll() {
		String qlString = "select u from User u order by u.id desc";
		TypedQuery<User> query = getEntityManager().createQuery(qlString, User.class);
		return query.getResultList();
	}
}
