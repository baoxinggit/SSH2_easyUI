package com.bx.ssh2.user.pageModal;

import java.util.HashSet;
import java.util.Set;

import com.bx.ssh2.user.po.RoleModule;

public class RoleModuleModal {
	private Set<RoleModule> roleModule = new HashSet<>();
	private int total;
	public Set<RoleModule> getRoleModule() {
		return roleModule;
	}
	public void setRoleModule(Set<RoleModule> roleModule) {
		this.roleModule = roleModule;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
}
