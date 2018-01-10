package com.tcs.ct.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.ct.dto.LeaveDTO;
import com.tcs.ct.exception.LeaveException;
import com.tcs.ct.model.LeaveDetails;
import com.tcs.ct.repo.LeaveRepo;

@Service
public class LeaveService {
	@Autowired
	LeaveRepo leaveRepo;
	
	public void saveLeaveDetails(LeaveDTO leaveDTO) throws LeaveException {
		LeaveDetails leaveDetails = new LeaveDetails();
		try {
			if(leaveDTO!=null)
			{
				leaveDetails.setEmpId(leaveDTO.getEmpId());
				leaveDetails.setStartDate(leaveDTO.getStartDate());
				leaveDetails.setEndDate(leaveDTO.getEndDate());
				leaveDetails.setApplied(leaveDTO.isApplied());
				leaveDetails.setReason(leaveDTO.getReason());
				leaveRepo.save(leaveDetails);
			}

		} catch (Exception e) {
			throw new LeaveException(e);
		}

	}

	
}
