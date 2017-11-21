package com.nt.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.dto.EmployeeDto;
import com.nt.service.ListEmpServiceImpl;


public class ListEmpController extends AbstractController {

	private ListEmpServiceImpl eservice;
	List<EmployeeDto> empList;
	ModelAndView MAV=null;

	public void setEservice(ListEmpServiceImpl eservice) {
		this.eservice = eservice;
	}

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		MAV=new ModelAndView();
		empList=eservice.getAllEmployeeDetail();
		MAV.setViewName("result");
		MAV.addObject("empList", empList);
		return MAV;
		//return new ModelAndView("result","empList", empList);
	}

}
