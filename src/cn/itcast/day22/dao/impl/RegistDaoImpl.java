package cn.itcast.day22.dao.impl;

import cn.itcast.day22.dao.RegistDao;
import cn.itcast.day22.domain.User;
import cn.itcast.day22.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;

public class RegistDaoImpl implements RegistDao {

	private QueryRunner queryRunner = new QueryRunner();
	
	@Override
	public User get(String id) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		String sql = "select id,name,password from tb_user where id=?";
		User user = (User) queryRunner.query(conn, sql, new BeanHandler(User.class) , id );
		
		return user;
	}

}
