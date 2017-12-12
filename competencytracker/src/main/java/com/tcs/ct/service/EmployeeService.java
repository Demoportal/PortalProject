package com.tcs.ct.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tcs.ct.dto.Competency;
import com.tcs.ct.model.Employee;

@Service
public class EmployeeService {
	
	
	public String test()
	{
		return "Welcome To Competency Tracker";
	}

	
	
	
	public Employee getEmployee(Integer employeeId)
	{
		Employee employee=new Employee();
		List<Competency> compList=new ArrayList<Competency>();
		employee.setEmployeeId(96754);
		employee.setEmployeeName("Anu");
		employee.setEmployeeEmail("abcd@tcs.com");
		employee.setEmployeePhone("9847060669");
		employee.setEmployeeDomain("Java");
		
		Competency competency=new Competency();
		competency.setCompetencyId(1024);
		competency.setCompetencyName("Core Java");
		competency.setCompetencyLevel("E1");
		
		Competency competency1=new Competency();
		competency.setCompetencyId(1045);
		competency.setCompetencyName("Unix");
		competency.setCompetencyLevel("E0");
		
		compList.add(competency);
		compList.add(competency1);
		employee.setCompetencyList(compList);
		return employee;
				
		
		
		
	}
}
