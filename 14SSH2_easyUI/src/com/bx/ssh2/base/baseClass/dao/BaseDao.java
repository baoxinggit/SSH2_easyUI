package com.bx.ssh2.base.baseClass.dao;

import java.util.List;


public interface BaseDao<T>{
	void save(T o);
	boolean login(String hql,String ...param);
	List<T> find(String hql);
	List<T> find(String hql,String... param);
	List<T> paging(String hql, Integer... param);
	Long count(String hql);
	T findById(T t, String id);
	void update(T t);
	boolean delete(Object param);
	List<T> findObjectById(String hql, Integer... value);
}
