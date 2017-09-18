package cn.itcast.day22.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AjaxServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("===异步请求到达doGet方法。");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println( username + ", " + password );
		
		resp.setContentType("text/html; charset=UTF-8");
		//发送给浏览器的响应信息
		resp.getWriter().println("这是从服务器doGet发送给浏览器的异步响应");
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("===异步请求到达doPost方法。");

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println( username + ", " + password );
		
		resp.setContentType("text/html; charset=UTF-8");
		//发送给浏览器的响应信息
		resp.getWriter().println("这是从服务器doPost发送给浏览器的异步响应");
	
	}

}
