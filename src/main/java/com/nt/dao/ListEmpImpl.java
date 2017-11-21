package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.nt.bo.EmployeeBo;

public class ListEmpImpl implements ListEmpDao {
	public static final String All_EMP_LIST="SELECT EMPNO,ENAME,JOB,SAL FROM EMP";
	private JdbcTemplate jt;
	List<EmployeeBo> empbo=null;
	

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Override
	public List<EmployeeBo> getAllEmployeeDetails() {
		empbo=(List<EmployeeBo>) jt.query(All_EMP_LIST,new EmpRowMapper());
		
		// TODO Auto-generated method stub
		return empbo;
	}
private class EmpRowMapper implements ResultSetExtractor {

	@Override
	public List<EmployeeBo> extractData(ResultSet rs) throws SQLException, DataAccessException {
		// TODO Auto-generated method stub
		List<EmployeeBo> lisbo= new ArrayList<EmployeeBo>();
		EmployeeBo bo=null;
		while(rs.next())
		{
			bo=new EmployeeBo();
			bo.setEmpno(rs.getInt(1));
			bo.setEname(rs.getString(2));
			bo.setJob(rs.getString(3));
			bo.setSalary(rs.getInt(4));
			lisbo.add(bo);
			
			
			
		}
		
		
		
		
		return lisbo;
	}
	
}
}
