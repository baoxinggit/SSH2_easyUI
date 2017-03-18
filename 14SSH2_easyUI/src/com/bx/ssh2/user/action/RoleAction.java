package com.bx.ssh2.user.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bx.ssh2.base.baseClass.action.BaseAction;
import com.bx.ssh2.base.util.JSON;
import com.bx.ssh2.user.pageModal.RoleModal;
import com.bx.ssh2.user.po.Role;
import com.bx.ssh2.user.service.RoleService;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
public class RoleAction extends BaseAction implements ModelDriven<Role> {

	private static final long serialVersionUID = -5381342927039763246L;
	
	private int page;
	private int rows;
	private String sort;
	private String order;
	private String searchId;
	private Role role = new Role();
	private String ids;
	
	@Autowired
	private RoleService roleService;
	
	//获取全部Role
	public String getRole() {
		RoleModal roles = roleService.getRole(sort,order,page,rows,searchId);
		this.writeJson(roles);
		return null;
	}

	//新增Role
	public String addRole() {
		JSON json = new JSON();
		try{
			roleService.addNewRole(role);
			json.setSuccess(true);
			json.setMsg("新增角色成功");
		}catch(Exception e){
			e.printStackTrace();
			json.setSuccess(false);
			json.setMsg("新增角色失败");
		}
		this.writeJson(json);
		return null;
	}

	//删除Role
	public String deleteRole(){
		JSON json = new JSON();
		try{
			roleService.delete(ids);
			json.setSuccess(true);
			json.setMsg("删除角色成功");
		}catch(Exception e){
			e.printStackTrace();
			json.setSuccess(false);
			json.setMsg("删除角色失败");
		}
		this.writeJson(json);
		return null;
	}
	
	//改变Role的信息
	public String changeRole(){
		JSON json = new JSON();
		try{
			roleService.change(role);
			json.setSuccess(true);
			json.setMsg("改变角色信息成功");
		}catch(Exception e){
			e.printStackTrace();
			json.setSuccess(false);
			json.setMsg("改变角色信息失败");
		}
		this.writeJson(json);
		return null;
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

	public String getSearchId() {
		return searchId;
	}

	public void setSearchId(String searchId) {
		this.searchId = searchId;
	}
	
}
