/*
* (C) Java Core
*
* @author DELL
* @date	5 thg 9, 2021
* @version 1.0
*/

package com.laptrinhjavaweb.dao;

import java.util.List;

import com.laptrinhjavaweb.model.NewsModel;

public interface INewDAO extends IGenericDAO<NewsModel> {
	
	NewsModel findOne(Long id);
	
	List<NewsModel> findByCategoryId(Long categoryId);

	Long save(NewsModel newsModel);

	void update(NewsModel newsModel);

	void delete(long id);
	
	List<NewsModel> findAll();

	int getTotalItem();
}
