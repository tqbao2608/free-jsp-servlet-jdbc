/*
* (C) Java Core
*
* @author DELL
* @date	5 thg 9, 2021
* @version 1.0
*/

package com.laptrinhjavaweb.service.impl;

import java.sql.Timestamp;
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
		newsModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		newsModel.setCreatedBy("");
		Long newId = newDAO.save(newsModel);
		System.out.println(newId);
		return newDAO.findOne(newId);
		
	}

	@Override
	public NewsModel update(NewsModel newsModel) {
		NewsModel oldNew = newDAO.findOne(newsModel.getId());
		newsModel.setCreatedDate(oldNew.getCreatedDate());
		newsModel.setCreatedBy(oldNew.getCreatedBy());
		newsModel.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		newsModel.setModifiedBy("");
		newDAO.update(newsModel);
		return newDAO.findOne(newsModel.getId());
	}

	@Override
	public void delete(long[] ids) {
		for(long id: ids) {
			newDAO.delete(id);
		}
		
	}

}
