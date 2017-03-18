package com.bx.ssh2.user.pageModal;

import java.util.ArrayList;
import java.util.List;

public class RoleModuleModal {
	private List<RoleModule> rows = new ArrayList<>();
	private int total;

	public List<RoleModule> getRows() {
		return rows;
	}

	public void setRows(List<RoleModule> rows) {
		this.rows = rows;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
}
