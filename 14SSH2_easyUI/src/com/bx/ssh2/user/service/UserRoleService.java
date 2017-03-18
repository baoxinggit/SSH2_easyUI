package com.bx.ssh2.user.service;

import com.bx.ssh2.user.pageModal.UserRoleModal;

public interface UserRoleService {

	UserRoleModal getUserRole(String sort, String order, int page,
			int rows, String searchId);

	boolean addUserRole(String userRoleId);

	boolean delUserRole(String userRoleId);
}
