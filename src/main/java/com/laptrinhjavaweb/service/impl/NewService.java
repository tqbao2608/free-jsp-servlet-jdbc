/*
* (C) Java Core
*
* @author DELL
* @date	5 thg 9, 2021
* @version 1.0
*/

package com.laptrinhjavaweb.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.laptrinhjavaweb.dao.INewDAO;
import com.laptrinhjavaweb.model.NewsModel;
import com.laptrinhjavaweb.service.INewService;

public class NewService implements INewService {
	@Inject
	private INewDAO newDAO;

	@Override
	public List<NewsModel> findByCategoryId(Long categoryId) {
		return newDAO.findByCategoryId(categoryId);
	}

	@Override
	public NewsModel save(NewsModel newsModel) {
		Long newId = newDAO.save(newsModel);
		System.out.println(newId);
		return newDAO.findOne(newId);
		
	}

	@Override
	public NewsModel delete(NewsModel newsModel) {
		newDAO.delete(newsModel);
		return null;
	}

	@Override
	public NewsModel update(NewsModel newsModel) {
		newDAO.update(newsModel);
		return null;
	}

}
