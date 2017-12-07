package com.tcs.ct.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PortalController {
	
	@RequestMapping(value="/hello")
	public String hello()
	{
		return "Welcome To Competency Tracker";
	}

}
