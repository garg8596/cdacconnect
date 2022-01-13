package com.app.core.pojos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
@Table(name="ExternalMarks")
public class ExternalMarks   {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(value = "externalId")
    private Integer externalId;
	@Column(length=1000,nullable=false)
	private String subjectName;
	
	@Column(length=20,nullable =false)
	
	private int theoryMarks;
	@Column(length=30,nullable = false)
	@Enumerated(EnumType.STRING)
	private ExamStatus studentStatus;
	
	@ManyToOne()
	@JoinColumn(name="studentId")
   	@JsonBackReference
	//optional BUT reco
private Student  studentexternalmarks;
	
	
	public Student getStudentexternalmarks() {
		return studentexternalmarks;
	}
	public void setStudentexternalmarks(Student studentexternalmarks) {
		this.studentexternalmarks = studentexternalmarks;
	}
	public ExternalMarks() {
		super();
	}
	public ExternalMarks( String subjectName, int theoryMarks, ExamStatus studentStatus) {
		super();
		
		this.subjectName = subjectName;
		this.theoryMarks = theoryMarks;
		this.studentStatus = studentStatus;
	}
	
	
	@Override
	public String toString() {
		return "ExternalMarks [externalId=" + externalId + ", subjectName=" + subjectName + ", theoryMarks="
				+ theoryMarks + ", studentStatus=" + studentStatus + "]";
	}
	public ExternalMarks( String subjectName, int theoryMarks, ExamStatus studentStatus,
			Student studentexternalmarks) {
		super();
		this.subjectName = subjectName;
		this.theoryMarks = theoryMarks;
		this.studentStatus = studentStatus;
	//	this.studentexternalmarks = studentexternalmarks;
	}
	public Integer getExternalId() {
		return externalId;
	}
	public void setExternalId(Integer externalId) {
		this.externalId = externalId;
	}
	
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public int getTheoryMarks() {
		return theoryMarks;
	}
	public void setTheoryMarks(int theoryMarks) {
		this.theoryMarks = theoryMarks;
	}
	public ExamStatus getStudentStatus() {
		return studentStatus;
	}
	public void setStudentStatus(ExamStatus studentStatus) {
		this.studentStatus = studentStatus;
	}
//	public Student getStudentexternalmarks() {
//		return studentexternalmarks;
//	}
//	public void setStudentexternalmarks(Student studentexternalmarks) {
//		this.studentexternalmarks = studentexternalmarks;
//	}
//	
//	
//	

}
