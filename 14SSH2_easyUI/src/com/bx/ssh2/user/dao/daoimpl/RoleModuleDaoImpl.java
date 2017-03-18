package com.bx.ssh2.user.dao.daoimpl;

import org.springframework.stereotype.Repository;

import com.bx.ssh2.base.baseClass.dao.impl.BaseDaoImpl;
import com.bx.ssh2.user.dao.RoleModuleDao;
import com.bx.ssh2.user.po.RoleModule;

@Repository("roleModuleDao")
public class RoleModuleDaoImpl extends BaseDaoImpl<RoleModule> implements RoleModuleDao{

}
