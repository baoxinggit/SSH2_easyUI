package com.bx.ssh2.menu.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bx.ssh2.base.baseClass.action.BaseAction;
import com.bx.ssh2.menu.pageModal.MenuModal;
import com.bx.ssh2.menu.po.Menu;
import com.bx.ssh2.menu.service.MenuService;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
public class MenuAction extends BaseAction implements ModelDriven<Menu>{
	private static final long serialVersionUID = 1L;
	private Menu menu = new Menu();
	@Autowired
	private MenuService menuService;
	public String getTree(){
		List<MenuModal> tree = menuService.findTree(menu);
		this.writeJson(tree);
		return null;
	}
	@Override
	public Menu getModel() {
		return menu;
	}
}
