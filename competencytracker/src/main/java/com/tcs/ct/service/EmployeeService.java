package com.tcs.ct.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.ct.dto.AddAllCompRequest;
import com.tcs.ct.dto.AddCompRequest;
import com.tcs.ct.dto.Competency;
import com.tcs.ct.dto.DeleteRequest;
import com.tcs.ct.dto.EditRequest;
import com.tcs.ct.dto.EmployeeRequest;
import com.tcs.ct.dto.ResponseDTO;
import com.tcs.ct.exception.CompetencyException;
import com.tcs.ct.model.CompetencyDetails;
import com.tcs.ct.model.Employee;
import com.tcs.ct.model.UserDetails;
import com.tcs.ct.repo.CompetencyRepo;
import com.tcs.ct.repo.EmployeeRepo;
import com.tcs.ct.repo.UserRepo;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepo employeeRepo;

	@Autowired
	UserRepo userRepo;
	
	@Autowired
	CompetencyRepo competencyRepo;
	public String test() {
		return "Welcome To Competency Tracker";
	}

	// public Employee getEmployee(Integer employeeId)
	// {
	// Employee employee=new Employee();
	// List<Competency> compList=new ArrayList<Competency>();
	// employee.setEmployeeId(96754);
	// employee.setEmployeeName("Anu");
	// employee.setEmployeeEmail("abcd@tcs.com");
	// employee.setEmployeePhone("9847060669");
	// employee.setEmployeeDomain("Java");
	//
	// Competency competency=new Competency();
	// competency.setCompetencyId(1024);
	// competency.setCompetencyName("Core Java");
	// competency.setCompetencyLevel("E1");
	//
	// Competency competency1=new Competency();
	// competency.setCompetencyId(1045);
	// competency.setCompetencyName("Unix");
	// competency.setCompetencyLevel("E0");
	//
	// compList.add(competency);
	// compList.add(competency1);
	// employee.setCompetencyList(compList);
	//
	// return employee;
	//
	//
	//
	//
	// }

	public List<Employee> getEmployeeDetails() throws CompetencyException {
		List<Employee> empList = new ArrayList<>();
		try {
			empList = employeeRepo.findAll();
			// empList=employeeRepo.findAll(arg0);
		} catch (Exception e) {
			throw new CompetencyException(e);
		}
		return empList;

	}

	public void saveEmployeeDetails(EmployeeRequest employeeRequest) throws CompetencyException {
		Employee employee1 = new Employee();
		try {
			if(employeeRequest!=null)
			{
				employee1.setEmployeeId(employeeRequest.getEmployeeId());
				employee1.setEmployeeDomain(employeeRequest.getEmployeeDomain());
				employee1.setEmployeeEmail(employeeRequest.getEmployeeEmail());
				employee1.setEmployeeName(employeeRequest.getEmployeeName());
				employee1.setEmployeePhone(employeeRequest.getEmployeePhone());
				employee1.setCompetencyList(employeeRequest.getCompetencyList());
				employeeRepo.save(employee1);
			}

		} catch (Exception e) {
			throw new CompetencyException(e);
		}

	}

	public Employee getCompetencyFrom(Integer employeeId) throws CompetencyException {

		Employee employee = new Employee();
		try {

			employee = employeeRepo.findByEmployeeId(employeeId);
			

		} catch (Exception e)

		{
			throw new CompetencyException(e);
		}
		return employee;
	}

	public void addCompetency(AddCompRequest addCompRequest) throws CompetencyException {

		Employee employee = new Employee();
		List<Competency> compList = new ArrayList<>();
		try {
			employee = employeeRepo.findByEmployeeId(addCompRequest.getEmployeeId());
			compList = employee.getCompetencyList();

			if (compList.contains(addCompRequest.getCompetency())) {
				throw new CompetencyException("Already existing competency");
			}

			compList.add(addCompRequest.getCompetency());
			employee.setCompetencyList(compList);
			employeeRepo.save(employee);
		} 
		catch (CompetencyException e) {
			throw e;
		} catch (Exception e) {
			throw new CompetencyException(e.getMessage());
		}


	}

	public void deleteEmployeeDetails(DeleteRequest deleteRequest) throws CompetencyException {
		Employee employee;
		Integer flag = 0;
		List<Competency> compList = null;

		try {

			// System.out.println("I am in");
			employee = employeeRepo.findByEmployeeId(deleteRequest.getEmployeeId());
			compList = employee.getCompetencyList();


			for (Integer comp : deleteRequest.getCompetencyList())

			{
				Iterator<Competency> itr = compList.iterator();
				while (itr.hasNext()) {
					Integer id = (itr.next().getCompetencyId());
					// System.out.println("HI"+itr.next().getCompetencyId());
					if (comp.equals(id)) {
						flag = 1;
						itr.remove();

					}

				}

			}
			if (flag == 0) {
				throw new CompetencyException("No record found");
			}

			employee.setCompetencyList(compList);
			employeeRepo.save(employee);
		} 
		catch (CompetencyException e) {
			throw e;
		} catch (Exception e) {
			throw new CompetencyException(e.getMessage());
		}

	}

	public ResponseDTO editCompetency(EditRequest editRequest) throws CompetencyException {
		Employee employee = new Employee();
		List<Competency> compList = null;
		Competency competency = new Competency();
		ResponseDTO response = new ResponseDTO();
		try {
			employee = employeeRepo.findByEmployeeId(editRequest.getEmployeeId());

			compList = employee.getCompetencyList();
			competency = editRequest.getCompetency();

			if (compList.contains(competency)) {
				compList.remove(competency);
				compList.add(competency);
			} else {

				throw new CompetencyException("No record found");
			}

			employee.setCompetencyList(compList);
			employeeRepo.save(employee);


		} catch (CompetencyException e) {
			throw e;
		} catch (Exception e) {
			throw new CompetencyException(e.getMessage());
		}
		return response;
	}
	
	public List<CompetencyDetails> getCompetency() throws CompetencyException
	{
		List<CompetencyDetails>	CompetencyDetails =new ArrayList<>();
		CompetencyDetails=competencyRepo.findAll();
		return CompetencyDetails;
		
	}

	public void addAllCompetency(AddAllCompRequest addAllCompRequest) throws CompetencyException{
		// TODO Auto-generated method stub
		CompetencyDetails competencyDetails= new CompetencyDetails();
		competencyDetails.setCompId(addAllCompRequest.getCompetencyId());
		competencyDetails.setCompList(addAllCompRequest.getCompList());
		competencyDetails.setCompName(addAllCompRequest.getCompetencyName());
		competencyRepo.save(competencyDetails);
	}
/*
	public  void deleteCompetency(Integer compid)  throws CompetencyException{
		// TODO Auto-generated method stub
		
		
		
		
	}*/

	public void addUser(UserDetails user) {
		// TODO Auto-generated method stub
		UserDetails userDetails= new UserDetails();
		
		userDetails.setUserName(user.getUserName());
		userDetails.setPassword(user.getPassword());
		userDetails.setRole(user.getRole());
		userRepo.save(userDetails);
		
	}
	
	
	
}
