package com.benz.portals.util;

import com.fasterxml.jackson.databind.util.JSONPObject;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class AppUtil  {
	
	public static Object returnObject(HttpServletRequest request, Map<String, Object> respMap){
		String callback = request.getParameter("callback");
		if ((null != callback) && (!"".equals(callback))) {
			return new JSONPObject(callback, respMap);
		}else{
			return respMap;
		}
	}
}
