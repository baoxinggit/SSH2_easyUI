package com.bx.ssh2.user.po;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Module {
	private int id;
	private String name;
	private Set<RoleModule> roleModule = new HashSet<>();
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@OneToMany(mappedBy="module")
	public Set<RoleModule> getRoleModule() {
		return roleModule;
	}
	public void setRoleModule(Set<RoleModule> roleModule) {
		this.roleModule = roleModule;
	}
}
