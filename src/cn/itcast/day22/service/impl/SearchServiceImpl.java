package cn.itcast.day22.service.impl;

import java.util.List;

import cn.itcast.day22.dao.SearchDao;
import cn.itcast.day22.dao.impl.SearchDaoImpl;
import cn.itcast.day22.domain.Product;
import cn.itcast.day22.service.SearchService;
import net.sf.json.JSONArray;

public class SearchServiceImpl implements SearchService {
	
	private SearchDao searchDao = new SearchDaoImpl();
	
	@Override
	public String getList(String keyword) throws Exception {
		//调用dao,查询所有和keyword相关的数据
		StringBuilder sb = new StringBuilder();
		sb.append(" name like '%"+ keyword + "%' ");
		sb.append(" or pinyin like '%");
		//遍历字符串中的每一个字符，在其间插入%,
		//例：abc  %a%b%c%
		for( int i = 0 ; i < keyword.length() ; i++ ){
			//取得当前字符
			String t = keyword.substring(i,i+1);
			sb.append(t+"%");
		}
		sb.append("'");
		//把条件字符串传入Dao的方法，执行查询
		List<Product> list = searchDao.search( sb.toString() );
		
		//把得到的结果集合转换成JSON字符返回
		String result = JSONArray.fromObject(list).toString();
		
		return result;
	}
}
