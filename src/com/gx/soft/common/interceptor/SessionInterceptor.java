package com.gx.soft.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SessionInterceptor implements HandlerInterceptor {
	private static final String LOGIN_URL = "/login/go-login.do";

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res,
			Object handler) throws Exception {
		HttpSession session = req.getSession(true);
		// 从session 里面获取用户名的信息
		boolean flag = true;
		Object obj = session.getAttribute("user_session");
		// 判断如果没有取到用户信息，就跳转到登陆页面，提示用户进行登陆
//		if(req.getContextPath())
//		System.out.println(req.getRequestURI());
//		System.out.println(!req.getRequestURI().equals("/njdtjsis/text/construction.do"));
//		if(!req.getRequestURI().equals("/njdtjsis/text/construction.do") && !req.getRequestURI().equals("/njdtjsis/text/generalize.do") && !req.getRequestURI().equals("/njdtjsis/text/show.do") ){
			if (obj == null || "".equals(obj.toString())) {
				res.sendRedirect(req.getContextPath() + LOGIN_URL);
				flag = false;
			}
//		}

		return flag;
	}

	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse res,
			Object arg2, ModelAndView arg3) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest req,
			HttpServletResponse res, Object arg2, Exception arg3)
			throws Exception {
	}
}
