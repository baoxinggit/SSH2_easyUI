package com.bx.ssh2.user.service.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bx.ssh2.user.dao.ModuleDao;
import com.bx.ssh2.user.dao.RoleDao;
import com.bx.ssh2.user.dao.RoleModuleDao;
import com.bx.ssh2.user.pageModal.ModuleModal;
import com.bx.ssh2.user.po.Module;
import com.bx.ssh2.user.po.Role;
import com.bx.ssh2.user.po.RoleModule;
import com.bx.ssh2.user.service.RoleModuleService;

@Service("roleModuleService")
@Transactional
public class RoleModuleServiceImpl implements RoleModuleService{

	@Autowired
	private ModuleDao moduleDao;
	@Autowired
	private RoleModuleDao roleModuleDao;
	@Autowired
	private RoleDao roleDao;
	@Override
	public ModuleModal getModuleByRoleId(int roleId) {
		List<Module> modules = moduleDao.find("from Module");
		for (Module module : modules) {
			module.setRoleModule(null);
		}
		List<RoleModule> roleModules = roleModuleDao.findObjectById("from RoleModule where role.id = ?", roleId);
		for (RoleModule roleModule : roleModules) {
			for (Module module : modules) {
				if(module.getId() == roleModule.getModule().getId()){
					module.setCode(roleModule.getCode());
				}
			}
		}
		ModuleModal mm = new ModuleModal();
		mm.getRows().addAll(modules);
		mm.setTotal(Long.valueOf(modules.size()));
		return mm;
	}

	@Override
	public boolean addRoleModule(int code, int roleId, int moduleId) {
		List<Role> role = roleDao.findObjectById("from Role where id = ?", roleId);
		if(role.size()>0){
			List<Module> module = moduleDao.findObjectById("from Module where id = ?", moduleId);
			if(module.size()>0){
				List<RoleModule> roleModule = roleModuleDao.findObjectById("from RoleModule where role.id = ? and module.id = ?", roleId,moduleId);
				RoleModule rm = new RoleModule();
				if(roleModule.size()>0){
					rm = roleModule.get(0);
					rm.setCode(rm.getCode() + code);
				}else{
					rm.setCode(code);
					rm.setModule(module.get(0));
					rm.setRole(role.get(0));
				}
				roleModuleDao.save(rm);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean delRoleModule(int code, int roleId, int moduleId) {
		List<Role> role = roleDao.findObjectById("from Role where id = ?", roleId);
		if(role.size()>0){
			List<Module> module = moduleDao.findObjectById("from Module where id = ?", moduleId);
			if(module.size()>0){
				List<RoleModule> roleModule = roleModuleDao.findObjectById("from RoleModule where role.id = ? and module.id = ?", roleId,moduleId);
				roleModule.get(0).setCode(roleModule.get(0).getCode() - code);
				roleModuleDao.update(roleModule.get(0));
				return true;
			}
		}
		return false;
	}
}
