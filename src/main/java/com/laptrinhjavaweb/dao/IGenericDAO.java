/*
* (C) Java Core
*
* @author DELL
* @date	7 thg 9, 2021
* @version 1.0
*/


package com.laptrinhjavaweb.dao;

import java.util.List;

import com.laptrinhjavaweb.mapper.IRowMapper;

public interface IGenericDAO<T>{
	List<T> query(String sql, IRowMapper<T> iRowMapper, Object... parameters);
	void update(String sql, Object... parameters);
	Long insert(String sql, Object... parameters);
}
