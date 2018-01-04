package com.tcs.ct.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.ct.dto.AddAllCompRequest;
import com.tcs.ct.dto.AddCompRequest;
import com.tcs.ct.dto.Competency;
import com.tcs.ct.dto.DeleteRequest;
import com.tcs.ct.dto.EditRequest;
import com.tcs.ct.dto.EmployeeRequest;
import com.tcs.ct.dto.GetEmployeeRequest;
import com.tcs.ct.dto.ResponseDTO;
import com.tcs.ct.exception.CompetencyException;
import com.tcs.ct.model.CompetencyDetails;
import com.tcs.ct.model.Employee;
import com.tcs.ct.model.UserDetails;
import com.tcs.ct.service.EmployeeService;

@CrossOrigin
@RestController

public class PortalController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/test")
	public String test() {
		return employeeService.test();
	}

	/*
	 * @GET
	 * 
	 * @Path("/test")
	 * 
	 * @Produces(MediaType.APPLICATION_JSON_VALUE) public String test() { return
	 * employeeService.test(); }
	 */

	// @RequestMapping(value="/getCompetency",method=RequestMethod.GET)
	// public Employee getCompetency(@RequestParam("employeeId") Integer
	// employeeId)
	// {
	// return employeeService.getEmployee(employeeId);
	// }

	// To get all employees

	@RequestMapping(value = "/getAllEmployee", method = RequestMethod.GET)
	public List<Employee> getEmployeeDetails() {
		List<Employee> empList = new ArrayList<>();
		try {
			empList = employeeService.getEmployeeDetails();
		} catch (CompetencyException e) {

		}
		return empList;
	}

	// To add new employee

	@RequestMapping(value = "/addEmployeedetails", method = RequestMethod.POST)
	public ResponseDTO getEmployeeDetails(@RequestBody EmployeeRequest employeeRequest) {
		ResponseDTO response = new ResponseDTO();
		try {
			employeeService.saveEmployeeDetails(employeeRequest);
			response.setResponseCode(0);
			response.setResponseMessage("EmployeeDetails added successfully");
		} catch (Exception e) {
			response.setResponseCode(1);
			response.setResponseMessage(e.getMessage());
		}
		return response;
	}

	// To delete competency of an employee
	@RequestMapping(value = "/deleteCompetency", method = RequestMethod.DELETE)
	public ResponseDTO deleteCompetencyDetails(@RequestBody DeleteRequest deleteRequest) {
		ResponseDTO response = new ResponseDTO();
		try

		{
			employeeService.deleteEmployeeDetails(deleteRequest);
			response.setResponseCode(0);
			response.setResponseMessage("CompetencyDetails got deleted successfully");

		} catch (Exception e) {
			response.setResponseCode(1);
			response.setResponseMessage(e.getMessage());
		}
		return response;
	}

	// To get a particular employee details
    
	@RequestMapping(value = "/getEmployee/{employeeId}",method=RequestMethod.GET)
	public Employee getCompetencyFrom( @PathVariable("employeeId") Integer employeeId){
		Employee employee = new Employee();

		try {
			employee = employeeService.getCompetencyFrom(employeeId);
		} catch (Exception e) {

		}
		return employee;
	}

	// To add competency details of an employee
	@RequestMapping(value = "/addCompetency", method = RequestMethod.POST)
	public ResponseDTO addCompetency(@RequestBody AddCompRequest addCompRequest) {
		ResponseDTO response = new ResponseDTO();
		try {
			employeeService.addCompetency(addCompRequest);
			response.setResponseCode(0);
			response.setResponseMessage("Competencies added successfully");

		} catch (Exception e) {
			response.setResponseCode(1);
			response.setResponseMessage(e.getMessage());
		}
		return response;

	}

	// To edit competency of an existing employee
	@RequestMapping(value = "/editCompetency", method = RequestMethod.PUT)
	public ResponseDTO editCompetetency(@RequestBody EditRequest editRequest) {
		ResponseDTO response = new ResponseDTO();
		try {

			response = employeeService.editCompetency(editRequest);
			response.setResponseCode(0);
			response.setResponseMessage("Competencies updated successwfully");
		} catch (Exception e) {
			response.setResponseCode(1);
			response.setResponseMessage(e.getMessage());
		}
		return response;

	}
	
	
	//To display competency 
	
	@RequestMapping(value = "/getAllCompetency", method = RequestMethod.GET)
	public List<CompetencyDetails> getAllCompetency() {
		List<CompetencyDetails> compList = new ArrayList<>();
		
			try {
				compList = employeeService.getCompetency();
			} catch (CompetencyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return compList;
	}

	
	
	@RequestMapping(value = "/addAllCompetency", method = RequestMethod.POST)
	public ResponseDTO addAllCompetency(@RequestBody AddAllCompRequest addAllCompRequest) {
		
		ResponseDTO responseDTO=new ResponseDTO();
		
		
		try {
			employeeService.addAllCompetency( addAllCompRequest);
			responseDTO.setResponseCode(0);
			responseDTO.setResponseMessage("Competencies succcesfuly added");
		} catch (CompetencyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			responseDTO.setResponseCode(1);
			responseDTO.setResponseMessage("Competencies failed to add");
		}
		
		return responseDTO;
	}
	/*@RequestMapping(value="/deleteCompetency" , method=RequestMethod.DELETE)
	public ResponseDTO deleteCompetency(@PathVariable("compId") Integer compId) throws CompetencyException
	{
		ResponseDTO response=new ResponseDTO();
		try
		{
		employeeService.deleteCompetency(compId);
		response.setResponseCode(0);
		response.setResponseMessage("Competencies succcesfuly deleted");
		}
		catch (CompetencyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.setResponseCode(1);
			response.setResponseMessage("Competencies failed to delete");
		}
		return response;
		
		
	}*/
	
	
}
