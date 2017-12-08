package com.tcs.ct.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
