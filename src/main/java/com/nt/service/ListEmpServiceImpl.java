package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.nt.bo.EmployeeBo;
import com.nt.dao.ListEmpImpl;
import com.nt.dto.EmployeeDto;

public class ListEmpServiceImpl implements ListEmpService {
	
	private ListEmpImpl dao;
	
	public void setDao(ListEmpImpl dao) {
		this.dao = dao;
	}

	@Override
	public List<EmployeeDto> getAllEmployeeDetail() {
		List<EmployeeBo> empList=dao.getAllEmployeeDetails();
		List<EmployeeDto> empListdto=new ArrayList<EmployeeDto>();
		EmployeeDto dto=null;
		for(EmployeeBo bo:empList)
		{
			dto=new EmployeeDto();
			BeanUtils.copyProperties(bo,dto);
			empListdto.add(dto);
		}
		// TODO Auto-generated method stub
		System.out.println(empListdto);
		return empListdto;
		
		
	}

}
