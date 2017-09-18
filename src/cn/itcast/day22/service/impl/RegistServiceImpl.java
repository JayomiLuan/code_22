package cn.itcast.day22.service.impl;

import java.sql.Connection;

import cn.itcast.day22.dao.RegistDao;
import cn.itcast.day22.dao.impl.RegistDaoImpl;
import cn.itcast.day22.domain.User;
import cn.itcast.day22.service.RegistService;
import cn.itcast.day22.utils.JdbcUtils;

public class RegistServiceImpl implements RegistService {

	private RegistDao registDao = new RegistDaoImpl();
	
	@Override
	public boolean isUsernameExist(String username) throws Exception {
		boolean flag = false;
		Connection conn = null;
		try{
			conn = JdbcUtils.getConnection();
			conn.setAutoCommit(false);
			//根据传入的用户名从数据库表中取得用户信息，如果取得成功，则返回false，如果取不到信息，说明此用户名未被使用，则返回true
			User user = registDao.get(username);
			//取得用户对象为空，说明此用户名不存在，可以使用，返回true
			if( user == null ){
				flag = true;
			}
			
			conn.commit();
		}catch(Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally{
			JdbcUtils.releaseResource(conn);
		}
	
		return flag;
	}

}
