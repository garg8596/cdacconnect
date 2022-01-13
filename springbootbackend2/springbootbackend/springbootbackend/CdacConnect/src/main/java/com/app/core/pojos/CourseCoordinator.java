package com.app.core.pojos;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="CourseCoordinator")
public class CourseCoordinator   {
	
	@Id
	@Column(length=20,unique = true,nullable=false)
	@JsonProperty(value = "courseId")
	private Integer courseId;
	@Column(length=50,unique = true,nullable=false)
	private String courseName;
	@Column(length=100,unique=true,nullable=false)
	private String coordinatorName;
	@Column(length=50,unique = true,nullable=false)
	private String cordinatorEmail;
	@Column(length=50)
	private String coordinatorPassword;
	@Column(length=50,nullable=false)
	private  String coordinatorPhoneNumber ;
	@Column(length=15,nullable=false)
	@Enumerated(EnumType.STRING)
	private Gender coordinatorGender;
	@Column(nullable=false)
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="IST")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate coordinatorDateofbirth;
	@Column(nullable=false)
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="IST")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate joiningDate;
	//mapping Student
	@OneToMany(mappedBy = "selectedCourse", cascade = CascadeType.PERSIST, orphanRemoval = true,fetch = FetchType.EAGER)
	
	private List<Student> students = new ArrayList<>();
	
	
	
	        
	//one to many  coordinator to sotm
			@OneToMany(mappedBy = "selectedMonthCourse", cascade = CascadeType.PERSIST, orphanRemoval = true)
			
			private List<StudentOfTheMonth> studentsofmonth=new ArrayList<StudentOfTheMonth>();
			
		
			//mapping  notices  to display
			@OneToMany(mappedBy = "selectedCourseNotice", cascade = CascadeType.PERSIST, orphanRemoval = true)
		
			private List<StudentNotices> studentNotices = new ArrayList<>();
			
	public CourseCoordinator() {
		super();
		
		System.out.println("Course coordinator default");
	}
	
	
	public CourseCoordinator(Integer courseId, String coordinatorPassword) {
		super();
		this.courseId = courseId;
		this.coordinatorPassword = coordinatorPassword;
	}


	public CourseCoordinator(int courseId, String courseName, String coordinatorName, String cordinatorEmail,
			String coordinatorPassword, String coordinatorPhoneNumber, Gender coordinatorGender,
			LocalDate coordinatorDateofbirth, LocalDate joiningDate) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.coordinatorName = coordinatorName;
		this.cordinatorEmail = cordinatorEmail;
		this.coordinatorPassword = coordinatorPassword;
		this.coordinatorPhoneNumber = coordinatorPhoneNumber;
		this.coordinatorGender = coordinatorGender;
		this.coordinatorDateofbirth = coordinatorDateofbirth;
		this.joiningDate = joiningDate;
		
	}
	
	
	
	
	public CourseCoordinator(Integer courseId, String courseName, String coordinatorName, String cordinatorEmail,
			String coordinatorPassword, String coordinatorPhoneNumber, Gender coordinatorGender,
			LocalDate coordinatorDateofbirth, LocalDate joiningDate) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.coordinatorName = coordinatorName;
		this.cordinatorEmail = cordinatorEmail;
		this.coordinatorPassword = coordinatorPassword;
		this.coordinatorPhoneNumber = coordinatorPhoneNumber;
		this.coordinatorGender = coordinatorGender;
		this.coordinatorDateofbirth = coordinatorDateofbirth;
		this.joiningDate = joiningDate;
	}


	@Override
	public String toString() {
		return "CourseCoordinator [courseId=" + courseId + ", courseName=" + courseName + ", coordinatorName="
				+ coordinatorName + ", cordinatorEmail=" + cordinatorEmail + ", coordinatorPassword="
				+ coordinatorPassword + ", coordinatorPhoneNumber=" + coordinatorPhoneNumber + ", coordinatorGender="
				+ coordinatorGender + ", coordinatorDateofbirth=" + coordinatorDateofbirth + ", joiningDate="
				+ joiningDate+"]";
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCoordinatorName() {
		return coordinatorName;
	}
	public void setCoordinatorName(String coordinatorName) {
		this.coordinatorName = coordinatorName;
	}
	public String getCordinatorEmail() {
		return cordinatorEmail;
	}
	public void setCordinatorEmail(String cordinatorEmail) {
		this.cordinatorEmail = cordinatorEmail;
	}
	public String getCoordinatorPassword() {
		return coordinatorPassword;
	}
	public void setCoordinatorPassword(String coordinatorPassword) {
		this.coordinatorPassword = coordinatorPassword;
	}
	public String getCoordinatorPhoneNumber() {
		return coordinatorPhoneNumber;
	}
	public void setCoordinatorPhoneNumber(String coordinatorPhoneNumber) {
		this.coordinatorPhoneNumber = coordinatorPhoneNumber;
	}
	public Gender getCoordinatorGender() {
		return coordinatorGender;
	}
	public void setCoordinatorGender(Gender coordinatorGender) {
		this.coordinatorGender = coordinatorGender;
	}
	public LocalDate getCoordinatorDateofbirth() {
		return coordinatorDateofbirth;
	}
	public void setCoordinatorDateofbirth(LocalDate coordinatorDateofbirth) {
		this.coordinatorDateofbirth = coordinatorDateofbirth;
	}
	public LocalDate getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}
	


}
