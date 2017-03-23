package com.benz.portals.web;

import com.benz.portals.controller.AdminController;
import com.benz.portals.util.page.SystemContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

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

	private static final Logger logger = LoggerFactory.getLogger(SystemContextFilter.class);

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

			logger.info(SystemContext.systemContextPrint());
			
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

