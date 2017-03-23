/**
 * Project Name:shcms
 * File Name:SystemContextFilter.java
 * Package Name:com.signhor.cms.web
 * Date:2017年3月15日上午10:36:21
 * Copyright (c) 2017, xyz@gmail.com All Rights Reserved.
 *
*/

package com.signhor.cms.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.signhor.cms.util.page.SystemContext;

/**
 * ClassName:SystemContextFilter
 * Function: 拦截过滤出一些基础数据
 * Date:     2017年3月15日 上午10:36:21
 * @author   zfg
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class SystemContextFilter implements Filter {
	
	private Integer pageSize;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		try {
			pageSize = Integer.parseInt(filterConfig.getInitParameter("pageSize"));
		} catch (NumberFormatException e) {
			pageSize = 10;
		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		Integer offset = 0;
		try {
			offset = Integer.parseInt(request.getParameter("pager.offset"));
		} catch (NumberFormatException e) {}
		try {
			SystemContext.setOrder(request.getParameter("order"));
			SystemContext.setSort(request.getParameter("sort"));
			SystemContext.setPageOffset(offset);
			SystemContext.setPageSize(pageSize);
			SystemContext.setRealPath(((HttpServletRequest)request).getSession().getServletContext().getRealPath("/"));
			
			SystemContext.systemContextPrint();
			
			chain.doFilter(request,response);
		} finally {
			SystemContext.removeOrder();
			SystemContext.removeSort();
			SystemContext.removePageOffset();
			SystemContext.removePageSize();
			SystemContext.removeRealPath();
		}
		
	}

	@Override
	public void destroy() {
		
		
	}
	
	

}

