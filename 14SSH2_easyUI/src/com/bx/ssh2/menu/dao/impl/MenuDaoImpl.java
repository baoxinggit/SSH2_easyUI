package com.bx.ssh2.menu.dao.impl;

import org.springframework.stereotype.Repository;

import com.bx.ssh2.base.baseClass.dao.impl.BaseDaoImpl;
import com.bx.ssh2.menu.dao.MenuDao;
import com.bx.ssh2.menu.po.Menu;

@Repository("menuDao")
public class MenuDaoImpl extends BaseDaoImpl<Menu> implements MenuDao{
}
