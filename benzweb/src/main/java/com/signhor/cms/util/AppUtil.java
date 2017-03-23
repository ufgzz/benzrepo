package com.signhor.cms.util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.databind.util.JSONPObject;

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
