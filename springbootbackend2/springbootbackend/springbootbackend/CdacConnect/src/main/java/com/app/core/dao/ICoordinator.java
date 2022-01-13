package com.app.core.dao;
import java.time.LocalDate;

import com.app.core.pojos.*;
public interface ICoordinator {
	
	public CourseCoordinator ValidateLogin(int courseId,String password);
	public CourseCoordinator  validateSecurityQustion(int courseId,String email,LocalDate dataOfBirth);
	public CourseCoordinator updateNewpassword(CourseCoordinator cord);
	 public StudentNotices  insertNotice(StudentNotices notices);
	 public Coursecoordinatorcomplaints insertReplyComplaint(Coursecoordinatorcomplaints complaints);
	 public Coursecoordinatorcomplaints  viewComplaint(int complaintId);
	 
	 public CourseCoordinator  getCoordintorDetails(int courseId);
	 public StudentOfTheMonth insertStomDetails(StudentOfTheMonth stom);
	 public boolean removeNotice(StudentNotices notice);
	 public StudentNotices updateNotice(StudentNotices notice);
	 public StudentOfTheMonth updateStomDetails(StudentOfTheMonth studmonth);
	 public CourseCoordinator updateNewPassword(CourseCoordinator cc);
	

}
