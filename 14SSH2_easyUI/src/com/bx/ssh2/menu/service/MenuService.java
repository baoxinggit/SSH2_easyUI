package com.bx.ssh2.menu.service;

import java.util.List;

import com.bx.ssh2.menu.pageModal.MenuModal;
import com.bx.ssh2.menu.po.Menu;


public interface MenuService{
	List<MenuModal> findTree(Menu menu);
}
