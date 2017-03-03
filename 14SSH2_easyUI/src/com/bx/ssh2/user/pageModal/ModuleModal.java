package com.bx.ssh2.user.pageModal;

import java.util.HashSet;
import java.util.Set;

import com.bx.ssh2.user.po.Module;

public class ModuleModal {
	private Set<Module> module = new HashSet<>();
	private int total;
	public Set<Module> getModule() {
		return module;
	}
	public void setModule(Set<Module> module) {
		this.module = module;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
}
