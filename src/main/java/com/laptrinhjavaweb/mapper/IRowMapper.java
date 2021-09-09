/*
* (C) Java Core
*
* @author DELL
* @date	7 thg 9, 2021
* @version 1.0
*/


package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;

public interface IRowMapper<T> {
	T mappRow(ResultSet resultSet);
}