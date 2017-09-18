package cn.itcast.day22.dao;

import cn.itcast.day22.domain.User;

public interface RegistDao {
	User get(String id) throws Exception;
}
