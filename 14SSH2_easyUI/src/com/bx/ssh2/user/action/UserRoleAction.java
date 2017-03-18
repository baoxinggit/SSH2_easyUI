package com.bx.ssh2.user.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.bx.ssh2.base.baseClass.action.BaseAction;
import com.bx.ssh2.base.util.JSON;
import com.bx.ssh2.user.pageModal.UserRoleModal;
import com.bx.ssh2.user.po.User;
import com.bx.ssh2.user.service.UserRoleService;
import com.opensymphony.xwork2.ModelDriven;

public class UserRoleAction extends BaseAction implements ModelDriven<User>{
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UserRoleService userRoleSerivce;
	
	private int page;
	private int rows;
	private String sort;
	private String order;
	private String searchId;
	private User user = new User();
	private String ids;
	private String userRoleId;
	
	public void getUserRole(){
		UserRoleModal userRoleModal = userRoleSerivce.getUserRole(sort,order,page,rows,searchId);
		for(User user : userRoleModal.getRows()){
			for(com.bx.ssh2.user.po.Role role : user.getRole())
				System.out.println(role.toString());
			System.out.println(); 
		}
		this.writeJson(userRoleModal);
	}
	
	public void addUserRole(){
		JSON json = new JSON();
		try{
			boolean addUserRoleStatus = userRoleSerivce.addUserRole(userRoleId);
			if(addUserRoleStatus){
				json.setSuccess(true);
				json.setMsg("添加角色成功");
			}else{
				json.setSuccess(false);
				json.setMsg("添加角色失败");
			}
		} catch(Exception e){
			json.setSuccess(false);
			json.setMsg("添加角色失败");
		} finally{
			this.writeJson(json);
		}
	}
	
	public void delUserRole(){
		JSON json = new JSON();
		try{
			boolean addUserRoleStatus = userRoleSerivce.delUserRole(userRoleId);
			if(addUserRoleStatus){
				json.setSuccess(true);
				json.setMsg("移除角色成功");
			}else{
				json.setSuccess(false);
				json.setMsg("移除角色失败");
			}
		} catch(Exception e){
			json.setSuccess(false);
			json.setMsg("移除角色失败");
		} finally{
			this.writeJson(json);
		}
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
		return userRoleId;
	}

	public void setUserRoleId(String userRoleId) {
		this.userRoleId = userRoleId;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	@Override
	public User getModel() {
		return user;
	}
}
