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

import com.laptrinhjavaweb.model.NewsModel;

public class NewMapper implements IRowMapper<NewsModel>{

	@Override
	public NewsModel mappRow(ResultSet resultSet) {
		NewsModel newsModel = new NewsModel();
		try {
			newsModel.setId(resultSet.getLong("id"));
			newsModel.setTitle(resultSet.getString("title"));
			newsModel.setContent(resultSet.getString("content"));
			newsModel.setCategoryId(resultSet.getLong("categoryid"));
			newsModel.setThumbnail(resultSet.getString("thumbnail"));
			newsModel.setShortDescription(resultSet.getString("shortdescription"));
			newsModel.setCreatedDate(resultSet.getTimestamp("createddate"));
			newsModel.setCreatedBy(resultSet.getString("createdby"));
			if(resultSet.getTimestamp("modifieddate") != null) {
				newsModel.setModifiedDate(resultSet.getTimestamp("modifieddate"));
			}
			if(resultSet.getString("modifiedby") != null) {
				newsModel.setModifiedBy(resultSet.getString("modifiedby"));
			}
			return newsModel;
		} catch (SQLException e) {
			return null;
		}
		
		
	}

}
