package com.tcs.ct.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.ct.dto.AddCompRequest;
import com.tcs.ct.dto.Competency;
import com.tcs.ct.dto.DeleteRequest;
import com.tcs.ct.dto.EditRequest;
import com.tcs.ct.dto.EmployeeRequest;
import com.tcs.ct.exception.CompetencyException;
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

	
	
	
//	public Employee getEmployee(Integer employeeId)
//	{
//		Employee employee=new Employee();
//		List<Competency> compList=new ArrayList<Competency>();
//		employee.setEmployeeId(96754);
//		employee.setEmployeeName("Anu");
//		employee.setEmployeeEmail("abcd@tcs.com");
//		employee.setEmployeePhone("9847060669");
//		employee.setEmployeeDomain("Java");
//		
//		Competency competency=new Competency();
//		competency.setCompetencyId(1024);
//		competency.setCompetencyName("Core Java");
//		competency.setCompetencyLevel("E1");
//		
//		Competency competency1=new Competency();
//		competency.setCompetencyId(1045);
//		competency.setCompetencyName("Unix");
//		competency.setCompetencyLevel("E0");
//		
//		compList.add(competency);
//		compList.add(competency1);
//		employee.setCompetencyList(compList);
//	
//		return employee;
//				
//		
//		
//		
//	}
	
	
	
	public List<Employee> getEmployeeDetails() throws CompetencyException
	{
		List<Employee> empList=new ArrayList<>();
		try
		{
		empList=employeeRepo.findAll();
		}
		catch(Exception e)
		{
			throw new CompetencyException(e);
		}
		return empList;
		
		
	}
	
	
	public void saveEmployeeDetails(EmployeeRequest employeeRequest) throws CompetencyException
	{
		Employee employee1=new Employee();
			try
			{
		employee1.setEmployeeId(employeeRequest.getEmployeeId());
		employee1.setEmployeeDomain(employeeRequest.getEmployeeDomain());
		employee1.setEmployeeEmail(employeeRequest.getEmployeeEmail());
		employee1.setEmployeeName(employeeRequest.getEmployeeName());
		employee1.setEmployeePhone(employeeRequest.getEmployeePhone());
		employee1.setCompetencyList(employeeRequest.getCompetencyList());
		employeeRepo.save(employee1);
			}
			catch(Exception e)
			{
				throw new CompetencyException(e);
			}
	
		
		
	}




	public Employee getCompetencyFrom(Integer employeeId) throws CompetencyException {
		
		
		Employee employee=new Employee();
		try
		{
			
			employee=employeeRepo.findByEmployeeId(employeeId);
		
		}
		catch(Exception e)
		
		{
			throw new CompetencyException(e);
		}
		return employee;
	}
	
	

	public void addCompetency(AddCompRequest addCompRequest) throws CompetencyException {
		
		Employee employee=new Employee();
		List<Competency> compList=new ArrayList<>();
		try
		{
		employee= employeeRepo.findByEmployeeId(addCompRequest.getEmployeeId());
		compList=employee.getCompetencyList();
		compList.add(addCompRequest.getCompetency());
		employee.setCompetencyList(compList);
		employeeRepo.save(employee);
		}
		catch(Exception e)
		{
			throw new CompetencyException(e);
			
		}
		
	}




	public void deleteEmployeeDetails(DeleteRequest deleteRequest) throws CompetencyException{
		Employee employee;
		List <Competency> compList=new ArrayList<>();
		
		try
		{
		employee=employeeRepo.findByEmployeeId(deleteRequest.getEmployeeId());
		compList=employee.getCompetencyList();
		for(Competency comp:deleteRequest.getCompetencyList())
		{
			if (compList.contains(comp))
			{compList.remove(comp);
			}
			
			
		}
employee.setCompetencyList(compList);
employeeRepo.save(employee);
		}
		catch(Exception e)
		{
			throw new CompetencyException(e);
		}
			
				}




	public void editCompetency( EditRequest editRequest) throws CompetencyException {
		Employee employee=new Employee();
		List<Competency> compList=new ArrayList<>();
		Competency competency=new Competency();
		
		try
		{
		employee=employeeRepo.findByEmployeeId(editRequest.getEmployeeId());
		
		compList=employee.getCompetencyList();
		competency=editRequest.getCompetency();
		for(Competency comp2:compList)
		{
			if(comp2.getCompetencyId().equals(competency.getCompetencyId()))
			{
				compList.remove(comp2);
				compList.add(competency);
			}
			
		}
		
		employee.setCompetencyList(compList);
		employeeRepo.save(employee);
		
		}
		catch(Exception e)
		{
			throw new CompetencyException(e);
		}
		
		
	}
	
	
	
	
}
