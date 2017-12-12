package com.tcs.ct.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.ct.dto.DeleteRequest;
import com.tcs.ct.dto.EmployeeRequest;
import com.tcs.ct.model.Employee;
import com.tcs.ct.service.EmployeeService;

@RestController
public class PortalController {
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value="/test")
	public String test()
	{
		return employeeService.test();
	}

	
	
	@RequestMapping(value="/getCompetency",method=RequestMethod.GET)
	public Employee getCompetency(@RequestParam("employeeId") Integer employeeId)
	{
		return employeeService.getEmployee(employeeId);
	}
	
	

	@RequestMapping(value="/getEmployee",method=RequestMethod.GET)
	public List<Employee> getEmployeeDetails()
	{
		return employeeService.getEmployeeDetails();
	}
	
	
	
	@RequestMapping(value="/saveEmployeedetails",method=RequestMethod.POST)
	public void getEmployeeDetails(@RequestBody  EmployeeRequest employeeRequest)
	{
		employeeService.saveEmployeeDetails(employeeRequest);;
	}
	
	
	
	/*@RequestMapping(value="/deletecompetencydetails",method=RequestMethod.POST)
	public void getCompetencyDetails(@RequestBody DeleteRequest deleteRequest)
	{
		employeeService.deleteEmployeeDetails(deleteRequest);;
	}*/
	
	@RequestMapping(value="/getCompetencyFromDb",method=RequestMethod.GET)
	public Employee getCompetencyFrom(@RequestParam("employeeId") Integer employeeId)
	{
		return employeeService.getCompetencyFrom(employeeId);
	}
}
