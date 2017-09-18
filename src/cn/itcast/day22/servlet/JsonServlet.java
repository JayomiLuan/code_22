package cn.itcast.day22.servlet;

import cn.itcast.day22.domain.User;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JsonServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
/*		User user= new User();
		user.setId("user002");
		user.setName("张三");
		//使用JSON-LIB把对象转换成JSON字符串
		String temp = JSONObject.fromObject(user).toString();
*/
		/*List<String> list = new ArrayList<>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		//把List集合转成JSON
		String temp = JSONArray.fromObject(list).toString();
		System.out.println(temp);*/
		/*Map<String,String> map = new HashMap<>();
		map.put("aa","11");
		map.put("bb","22");
		map.put("cc","33");
		String temp = JSONArray.fromObject(map).toString();
		System.out.println("json string: " + temp );*/
		Map<String,User> map = new HashMap<>();
		map.put("aa", new User("user001","张三","1") );
		map.put("bb", new User("user002","李四","2") );
		map.put("cc", new User("user003","王五","3") );
		String temp = JSONArray.fromObject(map).toString();
		System.out.println("json string: " + temp );
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
