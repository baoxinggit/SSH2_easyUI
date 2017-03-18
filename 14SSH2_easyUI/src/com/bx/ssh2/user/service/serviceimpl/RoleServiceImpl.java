package com.bx.ssh2.user.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bx.ssh2.user.dao.RoleDao;
import com.bx.ssh2.user.pageModal.RoleModal;
import com.bx.ssh2.user.po.Role;
import com.bx.ssh2.user.service.RoleService;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService{
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private RoleModal roleModal;
	
	//获取全部的Role
	public RoleModal getRole(String sort,String order,int page, int rows, String searchId){
		String hql = "from Role";
		if(searchId !=null && !"".equals(searchId)){
			hql  = hql + " where name like '%" + searchId + "%'";
		}
		hql = hql + " order by " + sort + " "+order;
		List<Role> roles = roleDao.paging(hql,rows,page);
		List<Role> roless = new ArrayList<>();
		roleModal.getRows().clear();
		for(Role role : roles){
			try {
				roless.add((Role) role.clone());
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		}
		for (Role role : roless) {
			role.setUser(null);
			role.setRoleModule(null);
		}
		roleModal.getRows().addAll(roless);
		roleModal.setTotal(roleDao.count("select count(id) from Role"));
		return roleModal;
	}

	@Override
	public void addNewRole(Role role) {
		roleDao.save(role);
	}

	@Override
	public void delete(String ids) {
		String[] idStr = ids.split(",");
		for (String string : idStr) {
			List<Role> roles = roleDao.findObjectById("from Role where id = ?", Integer.parseInt(string));
			roleDao.delete(roles.get(0));
		}
	}

	@Override
	public void change(Role role) throws Exception {
		List<Role> list = roleDao.findObjectById("from Role where id = ?", role.getId());
		if(list.size()>0)
			BeanUtils.copyProperties(role, list.get(0));
		else{
			throw new Exception("无效的信息");
		}
		roleDao.save(list.get(0));
	}

}
