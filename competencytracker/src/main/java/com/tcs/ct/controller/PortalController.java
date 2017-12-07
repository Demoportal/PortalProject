package com.tcs.ct.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PortalController {
	
	@RequestMapping(value="/welcome")
	public String hello()
	{
		return "Welcome To Competency Tracker";
	}

}
