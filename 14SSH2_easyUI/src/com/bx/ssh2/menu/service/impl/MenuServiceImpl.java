package com.bx.ssh2.menu.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bx.ssh2.menu.dao.MenuDao;
import com.bx.ssh2.menu.pageModal.MenuModal;
import com.bx.ssh2.menu.po.Menu;
import com.bx.ssh2.menu.service.MenuService;


@Service("menuService")
@Transactional
public class MenuServiceImpl implements MenuService{
	
	@Autowired
	private MenuDao menuDao;
	@Override
	public List<MenuModal> findTree(Menu menu) {
		List<MenuModal> menuModal = new ArrayList<>();
		System.out.println(menu);
		String idStr = null;
		String hql = null;
		if(menu.getId() == null){
			idStr = "";
		}else{
			idStr = menu.getId();
		}
		System.out.println(idStr);
		if("".equals(idStr)){
			hql = "from Menu where pid is null";
		}else{
			hql = "from Menu where pid = '" + idStr + "'";
		}
		List<Menu> list = menuDao.find(hql);
		for (Menu menuItem : list) {
			MenuModal m = new MenuModal();
			BeanUtils.copyProperties(menuItem, m);
			Map<String,String> attributes = new HashMap<>();
			attributes.put("url", menuItem.getUrl());
			m.setAttributes(attributes);
			if(menuItem.getMenus() != null && menuItem.getMenus().size()>0){
				m.setState("closed");
			}else{
				m.setState("open");
			}
			menuModal.add(m);
		}
		return menuModal;
	}
	
}
