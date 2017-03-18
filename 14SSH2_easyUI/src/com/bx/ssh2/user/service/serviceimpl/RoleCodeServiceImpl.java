package com.bx.ssh2.user.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bx.ssh2.user.dao.ModuleDao;
import com.bx.ssh2.user.dao.RoleDao;
import com.bx.ssh2.user.pageModal.RoleModal;
import com.bx.ssh2.user.po.Role;
import com.bx.ssh2.user.service.RoleCodeService;

@Service("roleCodeService")
@Transactional
public class RoleCodeServiceImpl implements RoleCodeService{

	@Autowired
	private RoleDao roleDao;
	@Autowired
	private ModuleDao moduleDao;
	@Override
	public RoleModal getRoleCode(String sort, String order, int page,
			int rows, String searchId) {
		String hql = "from Role";
		if(searchId != null && "" != searchId){
			hql = hql + " where name like '%" + searchId + "%'";
		}
		hql = hql + " order by " + sort + " " + order;
		List<Role> roles = roleDao.paging(hql, rows, page);
		List<Role> role = new ArrayList<>();
		for(Role r : roles){
			try {
				role.add((Role) r.clone());
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		}
		for(Role r : role){
			r.setUser(null);
		}
		RoleModal roleModal = new RoleModal();
		roleModal.getRows().addAll(role);
		return roleModal;
	}
}
