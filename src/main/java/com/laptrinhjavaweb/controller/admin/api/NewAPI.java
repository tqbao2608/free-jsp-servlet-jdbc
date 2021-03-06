/*
* (C) Java Core
*
* @author DELL
* @date	9 thg 9, 2021
* @version 1.0
*/

package com.laptrinhjavaweb.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhjavaweb.model.NewsModel;
import com.laptrinhjavaweb.service.INewService;
import com.laptrinhjavaweb.utils.HttpUtil;

@WebServlet(urlPatterns = { "/api-admin-new" })
public class NewAPI extends HttpServlet {
	
	@Inject
	private INewService newService;
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		NewsModel  model = HttpUtil.of(request.getReader()).toModel(NewsModel.class);
		model = newService.save(model);
		mapper.writeValue(response.getOutputStream(), model);

	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		NewsModel  updateModel = HttpUtil.of(request.getReader()).toModel(NewsModel.class);
		updateModel = newService.update(updateModel);
		mapper.writeValue(response.getOutputStream(), updateModel);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		NewsModel  updateModel = HttpUtil.of(request.getReader()).toModel(NewsModel.class);
		newService.delete(updateModel.getIds());
		mapper.writeValue(response.getOutputStream(), "{}");
	}
	
}
