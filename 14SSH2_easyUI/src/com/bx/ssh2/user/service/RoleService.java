package com.bx.ssh2.user.service;

import com.bx.ssh2.user.pageModal.RoleModal;
import com.bx.ssh2.user.po.Role;

public interface RoleService {
	public RoleModal getRole(String sort, String order, int page, int rows, String searchId);

	public void addNewRole(Role role);

	public void delete(String ids);

	public void change(Role role) throws Exception;
}
