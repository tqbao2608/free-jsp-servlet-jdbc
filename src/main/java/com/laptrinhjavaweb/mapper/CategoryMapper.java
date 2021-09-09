/*
* (C) Java Core
*
* @author DELL
* @date	7 thg 9, 2021
* @version 1.0
*/


package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjavaweb.model.CategoryModel;

public class CategoryMapper implements IRowMapper<CategoryModel>{

	@Override
	public CategoryModel mappRow(ResultSet resultSet) {
		try {
			CategoryModel categoryModel = new CategoryModel();
				categoryModel.setId(resultSet.getLong("id"));
				categoryModel.setCode(resultSet.getString("code"));
				categoryModel.setName(resultSet.getString("name"));
				return categoryModel;
		} catch (SQLException e) {
			return null;
		}
	}
	
}
