package com.ssafy.board.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler)
		throws Exception {
			
		
		HttpSession session = request.getSession();
//		System.out.println(session.getAttribute("loginUser")+"??");
		if(session.getAttribute("loginUser")==null) {
			response.sendRedirect(request.getContextPath()+"/loginCheck");
			return false;
		}
		return true;
	}
}
