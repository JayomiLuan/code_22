package cn.itcast.day22.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.day22.service.SearchService;
import cn.itcast.day22.service.impl.SearchServiceImpl;

public class BaiduServlet extends HttpServlet {

	private SearchService searchService = new SearchServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//接收请求参数
		String keyword = req.getParameter("keyword");
		
		//调用业务逻辑，返回跟传入关键字相关的推荐信息
		String result = null;
		try {
			result = searchService.getList(keyword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//北海巨妖
		System.out.println("==="+ result);
		
		//把响应信息发给浏览器
		resp.setContentType("text/html; charset=UTF-8");
		resp.getWriter().println(result);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
