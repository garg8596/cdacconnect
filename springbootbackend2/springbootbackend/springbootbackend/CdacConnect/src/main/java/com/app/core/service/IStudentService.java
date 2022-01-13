package com.app.core.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.app.core.pojos.CourseCoordinator;
import com.app.core.pojos.Coursecoordinatorcomplaints;
import com.app.core.pojos.ExternalMarks;
import com.app.core.pojos.InternalMarks;
import com.app.core.pojos.Student;
import com.app.core.pojos.StudentComplaints;
import com.app.core.pojos.StudentNotices;
import com.app.core.pojos.StudentOfTheMonth;

public interface IStudentService {
	
	public Student  validateStudentLogin(int studentPrn,String studentPassword);
	  public Student  validateSecurityQuestion(int studentPrn,String email,LocalDate dataOfBirth);
	  public Student  insertStudentDetails(Student stud);
	  public  Student updateNewpassword(Student stud);
	  public List<StudentNotices> getListofNoticeActive();
	  public Student  getStudentDetails(int studentPrn);
	  public List<StudentNotices>  getStudentNotices();
	  public List<StudentOfTheMonth> getStomDetails();
	  public StudentComplaints insertComplaints(StudentComplaints sc);
	  public List<StudentComplaints> viewComplaints(int Studentprn);
	  public boolean removeComplaints(StudentComplaints scom);
	  public StudentComplaints getComplaint(int complaintId);
	  public StudentComplaints updateComplaint(StudentComplaints scomp);
	  public String validateStudentLogin1(int studentPrn, String studentPassword);
	  public StudentComplaints getComplaintsDetails(int studentComplaintId);
	  public StudentNotices getNoticesDetails(int noticeId);
	  public List<StudentComplaints> getAllComplaints();
	  public Student updateStudentDe(Student stud);
	  public InternalMarks internalMarkData( InternalMarks internalmark);
	
	  public StudentNotices viewNotices(Integer noticeId);
	  
	  public StudentComplaints updateStudentStatus(StudentComplaints  sc);
	  public StudentOfTheMonth getStom( Integer stomId);
	  public StudentNotices removeNotice(StudentNotices studNot);
	  
	  public List<Student>  getStudents();
	  public InternalMarks  insertInternalMarks(InternalMarks inmark);
	  
	  public ExternalMarks  insertExternalMarks(ExternalMarks ext);
	  public List<InternalMarks> listInternalMarks(Student studentmarks);
	  public List<ExternalMarks> listExternalMarks(Student studentmarks);

	  public Student updateStudentDetails(Student stud);
	  public Student validateEmail(String email);
	
	}