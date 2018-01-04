package com.tcs.ct.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.ct.model.UserDetails;
import com.tcs.ct.service.EmployeeService;

@CrossOrigin
@RestController
public class UserController {

	@Autowired
	EmployeeService employeeService;
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public void addUser(@RequestBody UserDetails user)
	{
		employeeService.addUser(user);
		
	}
	
}
