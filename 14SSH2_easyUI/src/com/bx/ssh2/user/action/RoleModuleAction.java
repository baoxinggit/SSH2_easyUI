package com.bx.ssh2.user.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bx.ssh2.base.baseClass.action.BaseAction;
import com.bx.ssh2.base.util.JSON;
import com.bx.ssh2.user.pageModal.ModuleModal;
import com.bx.ssh2.user.service.RoleModuleService;

@Controller
@Scope("prototype")
public class RoleModuleAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	
	private int roleId;
	@Autowired
	private RoleModuleService roleModuleService;
	private int code;
	private int moduleId;
	public void getRoleModule(){
		ModuleModal moduleModal = roleModuleService.getModuleByRoleId(roleId);
		this.writeJson(moduleModal);
	}

	public void addRoleModule(){
		JSON json = new JSON();
		try{
			boolean  addStatus = roleModuleService.addRoleModule(code,roleId,moduleId);
			if(addStatus){
				json.setSuccess(true);
				json.setMsg("添加权限成功");
			}else{
				json.setSuccess(false);
				json.setMsg("添加权限失败");
			}
		}catch(Exception e){
			json.setSuccess(false);
			json.setMsg("添加权限失败");
		} finally{
			this.writeJson(json);
		}
	}
	public void delRoleModule(){
		JSON json = new JSON();
		try{
			boolean  addStatus = roleModuleService.delRoleModule(code,roleId,moduleId);
			if(addStatus){
				json.setSuccess(true);
				json.setMsg("移除权限成功");
			}else{
				json.setSuccess(false);
				json.setMsg("移除权限失败");
			}
		}catch(Exception e){
			json.setSuccess(false);
			json.setMsg("移除权限失败");
		} finally{
			this.writeJson(json);
		}
	}
	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getModuleId() {
		return moduleId;
	}

	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}
}
