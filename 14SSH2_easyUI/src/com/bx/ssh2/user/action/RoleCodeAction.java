package com.bx.ssh2.user.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.bx.ssh2.base.baseClass.action.BaseAction;
import com.bx.ssh2.user.pageModal.RoleModal;
import com.bx.ssh2.user.po.Role;
import com.bx.ssh2.user.service.RoleCodeService;
import com.opensymphony.xwork2.ModelDriven;

public class RoleCodeAction extends BaseAction implements ModelDriven<Role>{
	private static final long serialVersionUID = 1L;

	@Autowired
	private RoleCodeService roleCodeService;
	
	private int page;
	private int rows;
	private String sort;
	private String order;
	private String searchId;
	private Role role = new Role();
	private String ids;
	private String roleModuleId;
	
	public void getRoleCode(){
		RoleModal roleModal = roleCodeService.getRoleCode(sort,order,page,rows,searchId);
		this.writeJson(roleModal);
	}
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public String getUserRoleId() {
		return roleModuleId;
	}

	public void setUserRoleId(String roleModuleId) {
		this.roleModuleId = roleModuleId;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getSearchId() {
		return searchId;
	}

	public void setSearchId(String searchId) {
		this.searchId = searchId;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	@Override
	public Role getModel() {
		return role;
	}

}
