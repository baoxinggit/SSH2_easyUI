package com.bx.ssh2.base.baseClass.dao;

import java.util.List;

import com.bx.ssh2.user.pojo.User;


public interface BaseDao<T>{
	void save(T o);
	boolean login(String hql,String ...param);
	List<T> find(String hql,String... param);
	List<T> paging(String hql, Integer... param);
	Long count(String hql);
	boolean delete(String[] idStr);
	void update(User user);
	T findById(T t, String id);
}
