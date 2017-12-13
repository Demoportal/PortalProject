package com.tcs.ct.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.ct.dto.AddCompRequest;
import com.tcs.ct.dto.DeleteRequest;
import com.tcs.ct.dto.EditRequest;
import com.tcs.ct.dto.EmployeeRequest;
import com.tcs.ct.dto.ResponseDTO;
import com.tcs.ct.exception.CompetencyException;
import com.tcs.ct.model.Employee;
import com.tcs.ct.service.EmployeeService;

@CrossOrigin
@RestController
public class PortalController {
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value="/test")
	public String test()
	{
		return employeeService.test();
	}

	
	
//	@RequestMapping(value="/getCompetency",method=RequestMethod.GET)
//	public Employee getCompetency(@RequestParam("employeeId") Integer employeeId)
//	{
//		return employeeService.getEmployee(employeeId);
//	}
	
	
	
	//To get all employees

	@RequestMapping(value="/getAllEmployee",method=RequestMethod.GET)
	public List<Employee> getEmployeeDetails()
	{
		List<Employee> empList=new ArrayList<>();
		try {
			empList=employeeService.getEmployeeDetails();
		} catch (CompetencyException e) {
			
			
		}
		return empList;
	}
	
	
	//To add new employee
	
	@RequestMapping(value="/addEmployeedetails",method=RequestMethod.POST)
	public ResponseDTO getEmployeeDetails(@RequestBody  EmployeeRequest employeeRequest)
	{
		ResponseDTO response = new ResponseDTO();
		try
		{
		employeeService.saveEmployeeDetails(employeeRequest);
		response.setResponseCode(0);
		response.setResponseMessage("EmployeeDetails added successfully");
		}
		catch(Exception e)
		{
			response.setResponseCode(1);
			response.setResponseMessage("Failed to add Employeedetails");
		}
		return response;
	}
	
	
	//To delete competency of an employee
	@RequestMapping(value="/deleteCompetency",method=RequestMethod.POST)
	public ResponseDTO deleteCompetencyDetails(@RequestBody DeleteRequest deleteRequest)
	{
		ResponseDTO response=new ResponseDTO();
		try
	
	{
		employeeService.deleteEmployeeDetails(deleteRequest);
		response.setResponseCode(0);
		response.setResponseMessage("CompetencyDetails got deleted successfully");
		
	}
		catch(Exception e)
		{
			response.setResponseCode(1);
			response.setResponseMessage("Failed to delete competency details" );
		}
		return response;
	}
	
	//To get a particular employee details
	
	@RequestMapping(value="/getEmployee",method=RequestMethod.GET)
	public Employee getCompetencyFrom(@RequestParam("employeeId") Integer employeeId)
	{ 
		Employee employee=new Employee();
	
	try
	{
		employee= employeeService.getCompetencyFrom(employeeId);
	}
	catch(Exception e)
	{
		
		}
	return employee;
	}
	
	
	//To add competency details of an employee
	@RequestMapping(value="/addCompetency",method=RequestMethod.POST)
	public ResponseDTO addCompetency(@RequestBody AddCompRequest addCompRequest)
	{
		ResponseDTO response=new ResponseDTO();
		try
		{
		 employeeService.addCompetency(addCompRequest);
		 response.setResponseCode(0);
		 response.setResponseMessage("Competency Details added successfully");
		}
		catch(Exception e)
		{
			 response.setResponseCode(1);
			 response.setResponseMessage("Failed to add  competency Details");
		}
		return response;
		
	}
	
	
	//To edit competency of an existing employee
	@RequestMapping(value="/editCompetency",method=RequestMethod.POST)
	public void editCompetetency(@RequestBody EditRequest editRequest)
	{try
	{
		 employeeService.editCompetency(editRequest);
	}
	catch(Exception e)
	{}
	
	}
	
}
