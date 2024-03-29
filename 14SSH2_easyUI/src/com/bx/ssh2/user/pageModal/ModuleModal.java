package com.bx.ssh2.user.pageModal;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bx.ssh2.user.po.Module;

@Component
public class ModuleModal {
	private List<Module> rows = new ArrayList<>();
	private Long total;
	public List<Module> getRows() {
		return rows;
	}
	public void setRows(List<Module> rows) {
		this.rows = rows;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
}
