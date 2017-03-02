package com.bx.ssh2.user.action;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bx.ssh2.base.baseClass.action.BaseAction;
import com.bx.ssh2.base.util.JSON;
import com.bx.ssh2.user.pageModal.UserModal;
import com.bx.ssh2.user.po.User;
import com.bx.ssh2.user.service.UserService;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope(value = "prototype")
public class UserAction extends BaseAction implements ModelDriven<User> {

	private static final long serialVersionUID = 1L;
	private User user = new User();
	private String ids;
	private int rows;
	private String searchId;
	private int page;
	private UserService userService;

	public String reg() throws IOException {
//		Map<String, Object> json = new HashMap<>();
		JSON json = new JSON();
		try {
			userService.regUser(user);
//			json.put("success", true);
//			json.put("msg", "注册成功");
			json.setSuccess(true);
			json.setMsg("注册成功");
		} catch (Exception e) {
//			json.put("success", "false");
//			json.put("msg", "注册失败");
			json.setSuccess(false);
			json.setMsg("注册失败");
		}
		super.writeJson(json);
		return null;
	}

	public String login() throws IOException {
//		Map<String, Object> json = new HashMap<>();
		JSON json = new JSON();
		try {
			boolean loginStatus = userService.loginUser(user);
			if (loginStatus) {
//				json.put("success", true);
//				json.put("msg", "登录成功");
				json.setSuccess(true);
				json.setMsg("登陆成功");
			} else {
//				json.put("success", "false");
//				json.put("msg", "登录失败");
				json.setSuccess(false);
				json.setMsg("登录失败");
			}
		} catch (Exception e) {
//			json.put("success", "false");
//			json.put("msg", "登录失败");
			json.setSuccess(false);
			json.setMsg("登录失败");
		}
		super.writeJson(json);
		return null;
	}

	public String getUser(){
		System.out.println(searchId);
		UserModal userModal = userService.paging(rows,page,searchId);
		this.writeJson(userModal);
		return null;
	}
	
	public String delete(){
		JSON json = new JSON();
		try{
			boolean delStruts = userService.delete(ids);
			json.setSuccess(delStruts);
			if(delStruts){
				json.setMsg("删除成功");
			}else{
				json.setMsg("删除失败");
			}
		}catch (Exception e) {
				json.setSuccess(false);
				json.setMsg("删除失败");
		}finally{
			this.writeJson(json);
		}
		return null;
	}
	
	public String change(){
		System.out.println(user.getId());
		System.out.println(user.getName());
		System.out.println(user.getPassword());
		JSON json = new JSON();
		try{
			userService.change(user);
			json.setSuccess(true);
			json.setMsg("修改成功");
		}catch (Exception e) {
				json.setSuccess(false);
				json.setMsg("修改失败");
		}finally{
			this.writeJson(json);
		}
		return null;
	}
	@Override
	public User getModel() {
		return user;
	}

	public UserService getUserService() {
		return userService;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getPage() {
		return page;
	}
	
	public String getSearchId() {
		return searchId;
	}

	public void setSearchId(String searchId) {
		this.searchId = searchId;
	}

	public void setPage(int page) {
		this.page = page;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}
}
