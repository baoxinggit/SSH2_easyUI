package com.bx.ssh2.user.service;

import com.bx.ssh2.user.pageModal.ModuleModal;

public interface RoleModuleService {

	ModuleModal getModuleByRoleId(int roleId);

	boolean addRoleModule(int code, int roleId, int moduleId);

	boolean delRoleModule(int code, int roleId, int moduleId);
}
