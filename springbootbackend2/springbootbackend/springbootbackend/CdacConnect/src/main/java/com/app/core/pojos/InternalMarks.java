package com.app.core.pojos;

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
@Table(name="InternalMarks")
public class InternalMarks {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(value = "internalId")
	private Integer internalId ;
	@Column(length=100,nullable=false)
	private String subjectName;
	@Column(length=10,nullable = false)
	private int LabInternal;
	@Column(length=10,nullable = false)
	private int LabExam;
	@Column(length=30,nullable = false)
	@Enumerated(EnumType.STRING)
	private ExamStatus studentStatus;
	
	@ManyToOne()
	@JoinColumn(name="studentPrn")
	@JsonBackReference
	//optional BUT reco
	private Student  studentmarks;

	
	
	public InternalMarks() {
		super();
	}



	public InternalMarks(String subjectName, int labInternal, int labExam, ExamStatus studentStatus) {
		super();
		this.subjectName = subjectName;
		LabInternal = labInternal;
		LabExam = labExam;
		this.studentStatus = studentStatus;
	}


	

	


	public Integer getInternalId() {
		return internalId;
	}



	public void setInternalId(Integer internalId) {
		this.internalId = internalId;
	}



	public String getSubjectName() {
		return subjectName;
	}



	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}



	public int getLabInternal() {
		return LabInternal;
	}



	public void setLabInternal(int labInternal) {
		LabInternal = labInternal;
	}



	public int getLabExam() {
		return LabExam;
	}



	public void setLabExam(int labExam) {
		LabExam = labExam;
	}



	public ExamStatus getStudentStatus() {
		return studentStatus;
	}



	public void setStudentStatus(ExamStatus studentStatus) {
		this.studentStatus = studentStatus;
	}



	public Student getStudentmarks() {
		return studentmarks;
	}



	public void setStudentmarks(Student studentmarks) {
		this.studentmarks = studentmarks;
	}



	
}
