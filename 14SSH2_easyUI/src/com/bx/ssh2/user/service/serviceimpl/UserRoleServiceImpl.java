package com.bx.ssh2.user.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bx.ssh2.user.dao.RoleDao;
import com.bx.ssh2.user.dao.UserDao;
import com.bx.ssh2.user.pageModal.UserRoleModal;
import com.bx.ssh2.user.po.Role;
import com.bx.ssh2.user.po.User;
import com.bx.ssh2.user.service.UserRoleService;

@Service("userRoleService")
@Transactional
public class UserRoleServiceImpl implements UserRoleService{
	@Autowired
	private UserDao userDao;
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private UserRoleModal userRoleModal;
	@Override
	public UserRoleModal getUserRole(String sort, String order, int page,
			int rows, String searchId) {
		String hql = "from User";
		if(searchId != null && !("").equals(searchId)){
			hql = hql + " where name like '%" + searchId + "%'";
		}
		hql = hql + " order by " + sort +" " + order;
		List<User> list = userDao.paging(hql , Integer.valueOf(rows), Integer.valueOf(page));
		List<Role> roles = roleDao.find("from Role");
		List<Role> tempRole = null;
		for(User user : list){
			tempRole = new ArrayList<>();
			for(Role r : roles){
				try {
					tempRole.add((Role) r.clone());
				} catch (CloneNotSupportedException e) {
					e.printStackTrace();
				}
			}
			for(Role role : tempRole){
				role.setUser(null);
				role.setRoleModule(null);
			}
			for (Role user_role : user.getRole()) {
				for (Role role : tempRole) {
					if(user_role.getId() == role.getId()){
						role.setCode(1);
					}
				}
			}
			user.getRole().clear();
			user.getRole().addAll(tempRole);
		}
		userRoleModal.setRows(list);
		hql = "select count(id) from User";
		userRoleModal.setTotal(userDao.count(hql));
		return userRoleModal;
	}
	@Override
	public boolean addUserRole(String userRoleId) {
		int roleId = Integer.parseInt(userRoleId.split(",")[0]);
		String userId = userRoleId.split(",")[1];
		String hqlUser = "from User where id = ?";
		List<User> user = userDao.find(hqlUser,userId);
		if(user.size()>0){
			String hqlRole = "from Role where id = ?";
			List<Role> role = roleDao.findObjectById(hqlRole, roleId);
			if(role.size()>0){
				role.get(0).getUser().add(user.get(0));
				return true;
			}
		}
		return false;
	}
	@Override
	public boolean delUserRole(String userRoleId) {
		int roleId = Integer.parseInt(userRoleId.split(",")[0]);
		String userId = userRoleId.split(",")[1];
		String hqlUser = "from User where id = ?";
		List<User> user = userDao.find(hqlUser,userId);
		if(user.size()>0){
			String hqlRole = "from Role where id = ?";
			List<Role> role = roleDao.findObjectById(hqlRole, roleId);
			if(role.size()>0){
				role.get(0).getUser().remove(user.get(0));
				return true;
			}
		}
		return false;
	}
}
