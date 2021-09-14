/*
* (C) Java Core
*
* @author DELL
* @date	5 thg 9, 2021
* @version 1.0
*/

package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.model.NewsModel;
import com.laptrinhjavaweb.paging.Pageble;

public interface INewService {
	List<NewsModel> findByCategoryId(Long categoryId);

	NewsModel save(NewsModel newsModel);

	NewsModel update(NewsModel newsModel);

	void delete(long[] ids);
	
	List<NewsModel> findAll(Pageble pageble);

	int getTotalItem();
	
}
