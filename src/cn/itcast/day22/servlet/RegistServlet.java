package cn.itcast.day22.servlet;

import cn.itcast.day22.service.RegistService;
import cn.itcast.day22.service.impl.RegistServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RegistServlet extends HttpServlet {

	private RegistService registService = new RegistServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//接收请求参数
		String username = req.getParameter("username");
		
		//调用业务逻辑，验证此用户名是否存在
		boolean flag = false;
		try {
			flag = registService.isUsernameExist(username);
		} catch (Exception e) {
			e.printStackTrace();

	}
		PrintWriter out = resp.getWriter();
		//发送响应信息到客户端浏览器
		if( flag ){
			//用户名可以使用
			out.print("t");
		}else{
			//用户名已被占用
			out.print("f");
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
