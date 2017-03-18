package com.bx.ssh2.user.pageModal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.bx.ssh2.user.po.Role;

@Component("roleModal")
public class RoleModal {
	private List<Role> rows = new ArrayList<>();
	private Long total;
	
	public List<Role> getRows() {
		return rows;
	}
	public void setRows(List<Role> rows) {
		this.rows = rows;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
}
