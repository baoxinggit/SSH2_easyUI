package com.bx.ssh2.user.po;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Role {
	private int id;
	private String name;
	private Set<User> user = new HashSet<>();
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
	
	@ManyToMany(mappedBy="role",cascade=CascadeType.ALL)
	public Set<User> getUser() {
		return user;
	}
	public void setUser(Set<User> user) {
		this.user = user;
	}
	@OneToMany(mappedBy="role")
	public Set<RoleModule> getRoleModule() {
		return roleModule;
	}
	public void setRoleModule(Set<RoleModule> roleModule) {
		this.roleModule = roleModule;
	}
}
