package com.bx.ssh2.user.pageModal;

import java.util.List;

import com.bx.ssh2.user.po.Module;
import com.bx.ssh2.user.po.Role;

public class RoleModule {
	private Role role;
	private List<Module> module;
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public List<Module> getModule() {
		return module;
	}
	public void setModule(List<Module> module) {
		this.module = module;
	}
}
