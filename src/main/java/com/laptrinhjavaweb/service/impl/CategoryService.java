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

import com.laptrinhjavaweb.dao.ICategoryDAO;
import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.service.ICategoryService;

public class CategoryService implements ICategoryService {
	@Inject
	private ICategoryDAO categoryDAO;

	@Override
	public List<CategoryModel> findAll() {
		return categoryDAO.findAll();
	}

}
