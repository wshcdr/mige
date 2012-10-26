package com.spark.core.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author hgu
 *
 */
public abstract class JpaDaoSupport implements DaoSupport {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public <T> T getEntity(Class<T> entityClass, Object id) {
		return entityManager.find(entityClass, id);
	}
	@Override
	public void remove(Object entity) {
		entityManager.remove(entity);
	}
	@Override
	public void merge(Object entity) {
		entityManager.merge(entity);
	}
	@Override
	public void persist(Object entity) {
		entityManager.persist(entity);
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}
