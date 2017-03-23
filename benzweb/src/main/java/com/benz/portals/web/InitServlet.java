package com.benz.portals.web;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class InitServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static WebApplicationContext wc;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		//初始化spring的工厂
		setWc(WebApplicationContextUtils.getWebApplicationContext(this.getServletContext()));
		
		System.out.println("------------------------系统初始化成功-----------------------------");

	}

	public static WebApplicationContext getWc() {
		return wc;
	}

	public static void setWc(WebApplicationContext wc) {
		InitServlet.wc = wc;
	}
	
	
}
