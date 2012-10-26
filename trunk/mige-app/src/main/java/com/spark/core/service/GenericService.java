package com.spark.core.service;


/**
 * @author hgu
 *
 */
public interface GenericService {

	<T> T getEntity(Class<T> entityClass, Object id);
	
	void create(Object entity);

	void merge(Object entity);

	void remove(Object entity);
	
}
