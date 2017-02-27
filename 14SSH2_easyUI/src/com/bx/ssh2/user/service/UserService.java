package com.bx.ssh2.user.service;

import com.bx.ssh2.user.pageModal.UserModal;
import com.bx.ssh2.user.pojo.User;

public interface UserService {
	void regUser(User user);

	boolean loginUser(User user);

	UserModal paging(int rows, int page, String searchId);

	boolean delete(String ids);

	void change(User user);
}
