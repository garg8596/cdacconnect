package com.app.core.pojos;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="Coursecoordinatorcomplaints")
public class Coursecoordinatorcomplaints   {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty(value = "coordinatiorComplaintId")
	private Integer coordinatiorcomplaintid;
	@Column(length=200,nullable = false)
	private String coordinatorComplaintSubjectName;
	@Column(nullable=false)
	private String coordinatorcomplaintDescription;
	
	@Column(length=10000,nullable = false,unique = true)
	private String complaintReply;
	@Column(nullable=false)
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="IST")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate coordinatorPostDate;
	@Column(length=20,nullable=false)
	@Enumerated(EnumType.STRING)
	private Complaint coordinatorComplaintStatus;
	
	
	@OneToOne
	@JoinColumn(name="studentcomplaintid")
	@JsonBackReference
	private StudentComplaints studComplaint;
	public Coursecoordinatorcomplaints() {
		super();
		
		System.out.println("Coursecoordinator complaint");
	}
	
	public Coursecoordinatorcomplaints(String coordinatorComplaintSubjectName, String coordinatorcomplaintDescription,
			String complaintReply, LocalDate coordinatorPostDate, Complaint coordinatorComplaintStatus) {
		super();
		this.coordinatorComplaintSubjectName = coordinatorComplaintSubjectName;
		this.coordinatorcomplaintDescription = coordinatorcomplaintDescription;
		this.complaintReply = complaintReply;
		this.coordinatorPostDate = coordinatorPostDate;
		this.coordinatorComplaintStatus = coordinatorComplaintStatus;
	}

	public Integer getCoordinatiorcomplaintid() {
		return coordinatiorcomplaintid;
	}
	public void setCoordinatiorcomplaintid(Integer coordinatiorcomplaintid) {
		this.coordinatiorcomplaintid = coordinatiorcomplaintid;
	}
	public String getCoordinatorComplaintSubjectName() {
		return coordinatorComplaintSubjectName;
	}
	public void setCoordinatorComplaintSubjectName(String coordinatorComplaintSubjectName) {
		this.coordinatorComplaintSubjectName = coordinatorComplaintSubjectName;
	}
	public String getCoordinatorcomplaintDescription() {
		return coordinatorcomplaintDescription;
	}
	public void setCoordinatorcomplaintDescription(String coordinatorcomplaintDescription) {
		this.coordinatorcomplaintDescription = coordinatorcomplaintDescription;
	}
	public LocalDate getCoordinatorPostDate() {
		return coordinatorPostDate;
	}
	public void setCoordinatorPostDate(LocalDate coordinatorPostDate) {
		this.coordinatorPostDate = coordinatorPostDate;
	}
	public Complaint getCoordinatorComplaintStatus() {
		return coordinatorComplaintStatus;
	}
	public void setCoordinatorComplaintStatus(Complaint coordinatorComplaintStatus) {
		this.coordinatorComplaintStatus = coordinatorComplaintStatus;
	}
	public String getComplaintReply() {
		return complaintReply;
	}
	public void setComplaintReply(String complaintReply) {
		this.complaintReply = complaintReply;
	}
	public StudentComplaints getStudComplaint() {
		return studComplaint;
	}
	public void setStudComplaint(StudentComplaints studComplaint) {
		this.studComplaint = studComplaint;
	}
	
	
	

}
