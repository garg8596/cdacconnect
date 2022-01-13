package com.app.core.service;

import java.time.LocalDate;

import com.app.core.pojos.CourseCoordinator;
import com.app.core.pojos.Coursecoordinatorcomplaints;
import com.app.core.pojos.StudentNotices;
import com.app.core.pojos.StudentOfTheMonth;

public interface ICoordinatorService {
	
	 public CourseCoordinator ValidateLogin(int courseId,String password);
	 public CourseCoordinator  validateSecurityQustion(int courseId,String email,LocalDate dataOfBirth);
	 public CourseCoordinator updateNewpassword(CourseCoordinator cord);
	 public StudentNotices  insertNotice(StudentNotices notices);
	 public StudentNotices  updateNotice(StudentNotices notices);
	 public Coursecoordinatorcomplaints insertReplyComplaint(Coursecoordinatorcomplaints complaints);
	 public Coursecoordinatorcomplaints  viewComplaint(int complaintId);
	 public CourseCoordinator  getCoordintorDetails(int courseId);
	 public StudentOfTheMonth insertStomDetails(StudentOfTheMonth stom);
	 public StudentOfTheMonth updateStomDetails(StudentOfTheMonth studmonth);	 
	 public CourseCoordinator updateNewPassword(CourseCoordinator cc);

}
