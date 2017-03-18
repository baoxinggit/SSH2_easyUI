package com.bx.ssh2.user.service.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bx.ssh2.user.dao.ModuleDao;
import com.bx.ssh2.user.pageModal.ModuleModal;
import com.bx.ssh2.user.po.Module;
import com.bx.ssh2.user.service.ModuleService;

@Service("moduleService")
@Transactional
public class ModuleServiceImpl implements ModuleService{
		@Autowired
		private ModuleDao moduleDao;
		@Autowired
		private ModuleModal moduleModal;
		
		//获取全部的Module
		public ModuleModal getModule(String sort,String order,int page, int rows, String searchId){
			String hql = "from Module";
			if(searchId !=null && !"".equals(searchId)){
				hql  = hql + " where name like '%" + searchId + "%'";
			}
			if(order!= null && !"".equals(order))
			hql = hql + " order by " + sort + " "+order;
			List<Module> modules = moduleDao.paging(hql,rows,page);
			moduleModal.getRows().clear();
			for (Module module : modules) {
				module.setRoleModule(null);
				moduleModal.getRows().add(module);
			}
			moduleModal.setTotal(moduleDao.count("select count(id) from Module"));
			return moduleModal;
		}

		@Override
		public void addNewModule(Module module) {
			moduleDao.save(module);
		}

		@Override
		public void delete(String ids) {
			String[] idStr = ids.split(",");
			for (String string : idStr) {
				List<Module> modules = moduleDao.findObjectById("from Module where id = ?", Integer.parseInt(string));
				moduleDao.delete(modules.get(0));
			}
		}

		@Override
		public void change(Module module) throws Exception {
			List<Module> list = moduleDao.findObjectById("from Module where id = ?", module.getId());
			if(list.size()>0)
				BeanUtils.copyProperties(module, list.get(0));
			else{
				throw new Exception("无效的信息");
			}
			moduleDao.save(list.get(0));
		}

	}
