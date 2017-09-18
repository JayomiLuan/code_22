package cn.itcast.day22.dao;

import java.util.List;

import cn.itcast.day22.domain.Product;

public interface SearchDao {
	List<Product> search( String condition ) throws Exception;
}
