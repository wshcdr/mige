package com.spark.core.service;

import org.springframework.transaction.annotation.Transactional;

import com.spark.core.dao.GenericDao;

/**
 * @author hgu
 *
 */
public class GenericServiceImpl implements GenericService {
	private GenericDao genericDao;

	@Override
	@Transactional(readOnly=true)
	public <T> T getEntity(Class<T> entityClass, Object id) {
		return genericDao.getEntity(entityClass, id);
	}

	@Override
	@Transactional
	public void remove(Object entity) {
		genericDao.remove(entity);
	}

	@Override
	@Transactional
	public void merge(Object entity) {
		genericDao.merge(entity);
	}
	
	@Override
	@Transactional
	public void create(Object entity) {
		genericDao.persist(entity);
	}

	public GenericDao getGenericDao() {
		return genericDao;
	}

	public void setGenericDao(GenericDao genericDao) {
		this.genericDao = genericDao;
	}
}
