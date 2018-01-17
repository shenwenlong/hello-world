package com.shenwl.test.springmvc.access;






import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class AllInterceptor extends HandlerInterceptorAdapter{

	/*@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		ServletContext sc = request.getServletContext().getContext("USER");
		if (sc != null)
			return true;
		else {
			response.sendRedirect(request.getContextPath()+"/");
		}
		return false;
		
	}*/
}
