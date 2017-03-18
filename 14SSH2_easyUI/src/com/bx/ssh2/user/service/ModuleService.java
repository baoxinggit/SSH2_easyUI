package com.bx.ssh2.user.service;

import com.bx.ssh2.user.pageModal.ModuleModal;
import com.bx.ssh2.user.po.Module;

public interface ModuleService {
	public ModuleModal getModule(String sort, String order, int page, int rows, String searchId);

	public void addNewModule(Module module);

	public void delete(String ids);

	public void change(Module module) throws Exception;
}
