package com.bx.ssh2.base.baseClass.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.bx.ssh2.base.baseClass.dao.BaseDao;
import com.bx.ssh2.menu.po.Menu;
import com.bx.ssh2.user.pojo.User;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

	@Autowired
	public void setSession(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public void save(T o) {
		this.getHibernateTemplate().save(o);
	}

	@Override
	public boolean login(String hql, String... param) {
		List<T> find = (List<T>) this.getHibernateTemplate().find(hql, param);
		return find.size() > 0 ? true : false;
	}

	@Override
	public List<T> find(String hql, String... param) {
		return (List<T>) this.getHibernateTemplate().find(hql, param);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> paging(String hql, Integer... param) {
		Session session = this.getSessionFactory().getCurrentSession();
		Query query = session.createQuery(hql)
				.setFirstResult(param[0] * (param[1] - 1))
				.setMaxResults(param[0]);
		return query.list();
	}

	@Override
	public Long count(String hql) {
		return (Long) this.getHibernateTemplate().iterate(hql).next();
	}

	@Override
	public boolean delete(String[] idStr) {
		for(String id : idStr){
			User user = this.getHibernateTemplate().get(User.class, id);
			if(user != null)
				this.getHibernateTemplate().delete(user);
		}
		return true;
	}

	@Override
	public void update(User user) {
		this.getHibernateTemplate().update(user);
	}

	@Override
	public T findById(T t,String id) {
		T tt = (T) this.getHibernateTemplate().get(t.getClass() , id);
		return tt;
	}
}