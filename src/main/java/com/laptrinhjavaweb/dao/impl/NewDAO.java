/*
* (C) Java Core
*
* @author DELL
* @date	5 thg 9, 2021
* @version 1.0
*/

package com.laptrinhjavaweb.dao.impl;

import java.util.List;

import com.laptrinhjavaweb.dao.INewDAO;
import com.laptrinhjavaweb.mapper.NewMapper;
import com.laptrinhjavaweb.model.NewsModel;

public class NewDAO extends AbstractDAO<NewsModel> implements INewDAO {
	
	@Override
	public NewsModel findOne(Long id) {
		String sql = "SELECT * FROM news WHERE id = ?";
		List<NewsModel> news = query(sql, new NewMapper(), id);
		return news.isEmpty() ? null : news.get(0);
	}

	@Override
	public List<NewsModel> findByCategoryId(Long categoryId) {
		String sql = "SELECT * FROM news WHERE categoryid = ?";
		return query(sql, new NewMapper(), categoryId);
	}

	@Override
	public Long save(NewsModel newsModel) {
		String sql = "INSERT INTO news (title, content, categoryid) VALUES (?, ?, ?)";
		return insert(sql, newsModel.getTitle(), newsModel.getContent(), newsModel.getCategoryId());
	}

	@Override
	public void update(NewsModel newsModel) {
		String sql = "UPDATE  news SET shortdescription = ? WHERE id = ?";
		update(sql, newsModel.getShortDescription(), newsModel.getId());

	}

	@Override
	public void delete(NewsModel newsModel) {
		String sql = "DELETE FROM news WHERE id = ?";
		update(sql, newsModel.getId());

	}

}
