package com.bx.ssh2.user.dao.daoimpl;

import org.springframework.stereotype.Repository;

import com.bx.ssh2.base.baseClass.dao.impl.BaseDaoImpl;
import com.bx.ssh2.user.dao.ModuleDao;
import com.bx.ssh2.user.po.Module;

@Repository("moduleDao")
public class ModuleDaoImpl extends BaseDaoImpl<Module> implements ModuleDao{
}
