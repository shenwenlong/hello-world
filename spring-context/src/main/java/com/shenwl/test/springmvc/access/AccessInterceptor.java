package com.shenwl.test.springmvc.access;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AccessInterceptor extends HandlerInterceptorAdapter {
	Log log = LogFactory.getLog(AccessInterceptor.class);
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {
		log.debug(this.getClass().getName()+" 拦截器启动");
		ServletContext sc = request.getServletContext().getContext("USERS");
		log.debug(request.getRequestURI().endsWith("login"));
		if(null != sc || request.getRequestURI().endsWith("login"))
			return true;
		else {
			response.sendRedirect(request.getContextPath()+"/");  
			return false;
		}
	}
}
