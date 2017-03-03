package com.bx.ssh2.user.pageModal;

import java.util.HashSet;
import java.util.Set;

import com.bx.ssh2.user.po.Role;

public class RolePModal {
	private Set<Role> role = new HashSet<>();
	private int totla;
	public Set<Role> getRole() {
		return role;
	}
	public void setRole(Set<Role> role) {
		this.role = role;
	}
	public int getTotla() {
		return totla;
	}
	public void setTotla(int totla) {
		this.totla = totla;
	}
}
