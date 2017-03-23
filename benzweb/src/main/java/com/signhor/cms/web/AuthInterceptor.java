/**
 * Project Name:shcms
 * File Name:AuthInterceptor.java
 * Package Name:com.signhor.cms.web
 * Date:2017年3月15日下午2:15:42
 * Copyright (c) 2017, xyz@gmail.com All Rights Reserved.
 *
*/

package com.signhor.cms.web;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.signhor.cms.model.CmsException;
import com.signhor.cms.model.User;



/**
 * ClassName:AuthInterceptor
 * Function: 拦截器权限配置
 * Date:     2017年3月15日 下午2:15:42
 * @author   zfg
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class AuthInterceptor extends HandlerInterceptorAdapter {
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		HttpSession session = request.getSession();
		/*
		 * 如果使用uploadify进行文件的上传，由于flash的bug问题，会产生一个新的session，此时验证失败
		 * 所以必须在此处获取一个原有的session，然后重置session信息
		 */
		String sid = request.getParameter("sid");
		if(sid!=null&&!"".equals(sid.trim())) {
			//当sid有值，就表示是通过uploadify上传文件，此时就应该获取原有的session
			session = CmsSessionContext.getSession(sid);
		}
		HandlerMethod hm = (HandlerMethod)handler;
		User user = (User)session.getAttribute("loginUser");
		if(user==null) {
			response.sendRedirect(request.getContextPath()+"/login");
		} else {
			boolean isAdmin = (Boolean)session.getAttribute("isAdmin");
			if(!isAdmin) {
				//不是超级管理人员，就需要判断是否有权限访问某些功能
				Set<String> actions = (Set<String>)session.getAttribute("allActions");
				String aname = hm.getBean().getClass().getName()+"."+hm.getMethod().getName();
				if(!actions.contains(aname)) throw new CmsException("没有权限访问该功能");
			}
		}
	
		return super.preHandle(request, response, handler);
	}
	

}

