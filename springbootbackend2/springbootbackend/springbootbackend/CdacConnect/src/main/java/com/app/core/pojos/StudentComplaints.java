package com.app.core.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;



@Entity
@Table(name="StudentComplaints")
public class StudentComplaints    {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty(value = "studentcomplaintId")
	private Integer studentComplaintId;
	@Column(length=20,nullable = false)
	private int studentPrn;
	@Column(length=200,nullable = false)
	private String complaintSubjectName;
	@Column(length=10000,nullable = false)
	private String complaintDescription;
	
	
	@Column(nullable=false)
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="IST")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate complaintDate;
	public List<Student> getStudentscomplaintsdetails() {
		return studentscomplaintsdetails;
	}
	public void setStudentscomplaintsdetails(List<Student> studentscomplaintsdetails) {
		this.studentscomplaintsdetails = studentscomplaintsdetails;
	}
	public Coursecoordinatorcomplaints getCoordComplaint() {
		return coordComplaint;
	}
	public void setCoordComplaint(Coursecoordinatorcomplaints coordComplaint) {
		this.coordComplaint = coordComplaint;
	}
	@Column(length=20,nullable = false)
	@Enumerated(EnumType.STRING)
	private Complaint complaintStatus;
	
	
	//Student to Studentcomplaint @many to many
	@ManyToMany(mappedBy="studentscomplaints", fetch = FetchType.EAGER)
	private List<Student> studentscomplaintsdetails = new ArrayList<>();
	
	@OneToOne(mappedBy = "studComplaint",cascade = CascadeType.PERSIST)
	@JsonManagedReference
	private  Coursecoordinatorcomplaints coordComplaint;
	
		
	public StudentComplaints() {
		super();
	System.out.println("StudentCompaint default constructor");
	}
	public StudentComplaints(int studentPrn, String complaintSubjectName, String complaintDescription,
			LocalDate complaintDate, Complaint complaintStatus) {
		super();
		this.studentPrn = studentPrn;
		this.complaintSubjectName = complaintSubjectName;
		this.complaintDescription = complaintDescription;
		this.complaintDate = complaintDate;
		this.complaintStatus = complaintStatus;
		
	}
	
	
	public StudentComplaints(int studentPrn, String complaintSubjectName, String complaintDescription) {
		super();
		this.studentPrn = studentPrn;
		this.complaintSubjectName = complaintSubjectName;
		this.complaintDescription = complaintDescription;
	}
	@Override
	public String toString() {
		return "StudentComplaints [studentComplaintId=" + studentComplaintId + ", studentPrn=" + studentPrn
				+ ", complaintSubjectName=" + complaintSubjectName + ", complaintDescription=" + complaintDescription
				+ ", complaintDate=" + complaintDate + ", complaintStatus=" + complaintStatus + "]";
	}
	
	
	public Integer getStudentComplaintId() {
		return studentComplaintId;
	}
	public void setStudentComplaintId(Integer studentComplaintId) {
		this.studentComplaintId = studentComplaintId;
	}
	public int getStudentPrn() {
		return studentPrn;
	}
	public void setStudentPrn(int studentPrn) {
		this.studentPrn = studentPrn;
	}
	public String getComplaintSubjectName() {
		return complaintSubjectName;
	}
	public void setComplaintSubjectName(String complaintSubjectName) {
		this.complaintSubjectName = complaintSubjectName;
	}
	public String getComplaintDescription() {
		return complaintDescription;
	}
	public void setComplaintDescription(String complaintDescription) {
		this.complaintDescription = complaintDescription;
	}
	public LocalDate getComplaintDate() {
		return complaintDate;
	}
	public void setComplaintDate(LocalDate complaintDate) {
		this.complaintDate = complaintDate;
	}
	public Complaint getComplaintStatus() {
		return complaintStatus;
	}
	public void setComplaintStatus(Complaint complaintStatus) {
		this.complaintStatus = complaintStatus;
	}

	
	
	
	
	

}
