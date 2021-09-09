/*
* (C) Java Core
*
* @author DELL
* @date	5 thg 9, 2021
* @version 1.0
*/


package com.laptrinhjavaweb.dao;

import java.util.List;
import com.laptrinhjavaweb.model.CategoryModel;

public interface ICategoryDAO extends IGenericDAO<CategoryModel> {
	List<CategoryModel> findAll();
}
