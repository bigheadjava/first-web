package com.hx.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginServlet extends GenericServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3208763727205735451L;

	/**
	 * 实现父类GenericServlet中的service方法，响应客户端的请求
	 */
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// 读取页面请求中的用户名
		String userName = req.getParameter("userName");
		// 读取页面请求中的密码
		String password = req.getParameter("userPassword");

		// 在request中添加userName属性
		req.setAttribute("userName", userName);

		// 判断登陆成功与否
		String target;
		if ("zhangsan".equals(userName) && "password".equals(password)) {
			target = "/jsp/loginSuccess.jsp";
		} else {
			target = "/jsp/loginFailed.jsp";
		}
		// 请求转发
		ServletContext ctx = this.getServletContext();
		RequestDispatcher dispatcher = ctx.getRequestDispatcher(target);
		dispatcher.forward(req, res);
	}
}
