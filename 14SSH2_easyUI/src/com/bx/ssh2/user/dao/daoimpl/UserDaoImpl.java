package com.bx.ssh2.user.dao.daoimpl;

import org.springframework.stereotype.Repository;

import com.bx.ssh2.base.baseClass.dao.impl.BaseDaoImpl;
import com.bx.ssh2.user.dao.UserDao;
import com.bx.ssh2.user.po.User;

@Repository(value="userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{
}