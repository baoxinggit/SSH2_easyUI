package com.bx.ssh2.base.baseClass.action;

import java.io.IOException;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author 兴
 * 基础action类
 * 对json数据进行写出
 */
public class BaseAction extends ActionSupport{
	public void writeJson(Object object) {
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		try {
			ServletActionContext.getResponse().getWriter().write(JSON.toJSONString(object));
			ServletActionContext.getResponse().getWriter().flush();
			ServletActionContext.getResponse().getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
