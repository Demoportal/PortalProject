package com.tcs.ct.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.ct.dto.Competency;
import com.tcs.ct.dto.DeleteRequest;
import com.tcs.ct.dto.EmployeeRequest;
import com.tcs.ct.model.Employee;
import com.tcs.ct.repo.EmployeeRepo;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepo employeeRepo;
	
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
	
	public List<Employee> getEmployeeDetails()
	{
		List<Employee> empList=new ArrayList<>();
		empList=employeeRepo.findAll();
		return empList;
		
		
	}
	public void saveEmployeeDetails(EmployeeRequest employeeRequest)
	{
		Employee employee1=new Employee();
			
		employee1.setEmployeeId(employeeRequest.getEmployeeId());
		employee1.setEmployeeDomain(employeeRequest.getEmployeeDomain());
		employee1.setEmployeeEmail(employeeRequest.getEmployeeEmail());
		employee1.setEmployeeName(employeeRequest.getEmployeeName());
		employee1.setEmployeePhone(employeeRequest.getEmployeePhone());
		employee1.setCompetencyList(employeeRequest.getCompetencyList());
		employeeRepo.save(employee1);
		
	
		
		
	}




	public Employee getCompetencyFrom(Integer employeeId) {
		
		return employeeRepo.findByEmployeeId(employeeId);
	}




	/*public void deleteEmployeeDetails(DeleteRequest deleteRequest){
		
		
		employeeRepo.deleteByEmployeeIdAndCompetencyId(deleteRequest.getEmployeeId(),deleteRequest.getCompetencyId());
		
		
		
		
	}*/
	
}
