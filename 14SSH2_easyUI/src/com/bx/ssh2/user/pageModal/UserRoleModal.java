package com.bx.ssh2.user.pageModal;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bx.ssh2.user.po.User;

@Component
public class UserRoleModal {
	private List<User> rows = new ArrayList<>();
	private Long total;
	public List<User> getRows() {
		return rows;
	}
	public void setRows(List<User> rows) {
		this.rows = rows;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
}
