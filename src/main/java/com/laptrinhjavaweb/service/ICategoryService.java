/*
* (C) Java Core
*
* @author DELL
* @date	5 the 9, 2021
* @version 1.0
*/

package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.model.CategoryModel;

public interface ICategoryService {
	
	List<CategoryModel> findAll();
}
