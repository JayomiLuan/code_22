package cn.itcast.day22.dao.impl;

import cn.itcast.day22.dao.SearchDao;
import cn.itcast.day22.domain.Product;
import cn.itcast.day22.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.util.List;

public class SearchDaoImpl implements SearchDao {

	private QueryRunner queryRunner = new QueryRunner();
	
	@Override
	public List<Product> search(String condition) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		String sql = "select id,name,pinyin from tb_product where "+condition;
		System.out.println( "===sql: " + sql );
		List<Product> list = (List<Product>) queryRunner.query(conn, sql, new BeanListHandler(Product.class));
		return list;
	}
}
