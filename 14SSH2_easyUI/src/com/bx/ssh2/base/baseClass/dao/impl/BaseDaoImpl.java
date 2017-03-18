package com.bx.ssh2.base.baseClass.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.bx.ssh2.base.baseClass.dao.BaseDao;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

	@Autowired
	public void setSession(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public void save(T o) {
		this.getHibernateTemplate().save(o);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean login(String hql, String... param) {
		List<T> find = (List<T>) this.getHibernateTemplate().find(hql, param);
		return find.size() > 0 ? true : false;
	}

	@Override
	public List<T> find(String hql, String... param) {
		return (List<T>) this.getHibernateTemplate().find(hql, param);
	}

	@Override
	public List<T> paging(String hql, Integer... param) {
		Session session = this.getSessionFactory().getCurrentSession();
		Query query = session.createQuery(hql)
				.setFirstResult(param[0] * (param[1] - 1))
				.setMaxResults(param[0]);
		List<T> t = query.list();
		return t;
	}

	@Override
	public Long count(String hql) {
		return (Long) this.getHibernateTemplate().iterate(hql).next();
	}

	@Override
	public boolean delete(Object idStr){
		this.getHibernateTemplate().delete(idStr);
		return true;
	}

	@Override
	public void update(T t) {
		this.getHibernateTemplate().update(t);
	}

	@Override
	public T findById(T t,String id) {
		@SuppressWarnings("unchecked")
		T tt = (T) this.getHibernateTemplate().get(t.getClass() , id);
		return tt;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> find(String hql) {
		return (List<T>) this.getHibernateTemplate().find(hql);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findObjectById(String hql, Integer... value) {
		return (List<T>) this.getHibernateTemplate().find(hql, value);
	}
}