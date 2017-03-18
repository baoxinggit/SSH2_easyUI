package com.bx.ssh2.user.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bx.ssh2.base.baseClass.action.BaseAction;
import com.bx.ssh2.base.util.JSON;
import com.bx.ssh2.user.pageModal.ModuleModal;
import com.bx.ssh2.user.po.Module;
import com.bx.ssh2.user.service.ModuleService;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
public class ModuleAction extends BaseAction implements ModelDriven<Module> {

	private static final long serialVersionUID = -5381342927039763246L;
	
	private int page;
	private int rows;
	private String sort;
	private String order;
	private String searchId;
	private Module module = new Module();
	private String ids;
	
	@Autowired
	private ModuleService moduleService;
	
	//获取全部Module
	public String getModule() {
		ModuleModal modules = moduleService.getModule(sort,order,page,rows,searchId);
		this.writeJson(modules);
		return null;
	}

	//新增Module
	public String addModule() {
		JSON json = new JSON();
		try{
			moduleService.addNewModule(module);
			json.setSuccess(true);
			json.setMsg("新增模块成功");
		}catch(Exception e){
			e.printStackTrace();
			json.setSuccess(false);
			json.setMsg("新增模块失败");
		}
		this.writeJson(json);
		return null;
	}

	//删除Module
	public String deleteModule(){
		JSON json = new JSON();
		try{
			moduleService.delete(ids);
			json.setSuccess(true);
			json.setMsg("删除模块成功");
		}catch(Exception e){
			e.printStackTrace();
			json.setSuccess(false);
			json.setMsg("删除模块失败");
		}
		this.writeJson(json);
		return null;
	}
	
	//改变Module的信息
	public String changeModule(){
		JSON json = new JSON();
		try{
			moduleService.change(module);
			json.setSuccess(true);
			json.setMsg("改变模块信息成功");
		}catch(Exception e){
			e.printStackTrace();
			json.setSuccess(false);
			json.setMsg("改变模块信息失败");
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
	public Module getModel() {
		return module;
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
