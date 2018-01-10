package com.tcs.ct.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.ct.dto.LeaveDTO;
import com.tcs.ct.dto.ResponseDTO;
import com.tcs.ct.service.LeaveService;


@CrossOrigin
@RestController
public class LeaveController {
	
	@Autowired
	LeaveService leaveService;
	
	// To add new leave

		@RequestMapping(value = "/addLeaveDetails", method = RequestMethod.POST)
		public ResponseDTO addLeaveDetails(@RequestBody LeaveDTO leaveDTO) {
			ResponseDTO response = new ResponseDTO();
			try {
				leaveService.saveLeaveDetails(leaveDTO);
				response.setResponseCode(0);
				response.setResponseMessage("Leave Details added successfully");
			} catch (Exception e) {
				response.setResponseCode(1);
				response.setResponseMessage(e.getMessage());
			}
			return response;
		}
}
