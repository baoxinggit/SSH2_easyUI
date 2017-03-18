package com.bx.ssh2.user.service;

import com.bx.ssh2.user.pageModal.RoleModal;

public interface RoleCodeService {

	RoleModal getRoleCode(String sort, String order, int page, int rows,
			String searchId);
}
