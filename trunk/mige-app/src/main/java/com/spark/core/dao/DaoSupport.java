package com.spark.core.dao;
/**
 * @author hgu
 *
 */
public interface DaoSupport {

	public <T> T getEntity(Class<T> entityClass, Object id);

	public void remove(Object entity);

	public void merge(Object entity);

	public void persist(Object entity);
	
}
