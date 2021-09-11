package com.laptrinhjavaweb.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.model.NewsModel;
import com.laptrinhjavaweb.service.INewService;

@WebServlet(urlPatterns = { "/admin-new" })
public class NewController extends HttpServlet {
	/**
	 * 
	 */
	@Inject
	private INewService newService;
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		NewsModel model = new NewsModel();
		
		model.setListResult(newService.findAll());
		model.setTotalItem(model.getListResult().size());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getTotalPage()));
		request.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher rd = request.getRequestDispatcher("/view/admin/new/list.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{

	}
}
