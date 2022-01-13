package com.app.core.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="StudentOfTheMonth")
public class StudentOfTheMonth  
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty(value = "stomId")
	private Integer stomId;
	@Column(length=50,unique = true,nullable=false)
	private String monthName;
	@Column(length=20,unique = true,nullable=false)
	private int studentprn;
	
	@Column(length=10000,nullable=false)
	private String description;
     // mapping between stom to course
	@ManyToOne
	@JoinColumn(name="courseid")//optional BUT reco
	
	private CourseCoordinator selectedMonthCourse;
	
	public StudentOfTheMonth() {
		super();
		System.out.println("Studentof month default constructor");
	}

	public StudentOfTheMonth(String monthName, int studentprn, String description) {
		super();
		this.monthName = monthName;
		this.studentprn = studentprn;
		this.description = description;
	
	}

	@Override
	public String toString() {
		return "StudentOfTheMonth [stomId=" + stomId + ", monthName=" + monthName + ", studentprn=" + studentprn
				+ ", description=" + description + "]";
	}

	public Integer getStomId() {
		return stomId;
	}

	public void setStomId(Integer stomId) {
		this.stomId = stomId;
	}

	public String getMonthName() {
		return monthName;
	}

	public void setMonthName(String monthName) {
		this.monthName = monthName;
	}

	public int getStudentprn() {
		return studentprn;
	}

	public void setStudentprn(int studentprn) {
		this.studentprn = studentprn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	public CourseCoordinator getSelectedMonthCourse() {
//		return selectedMonthCourse;
//	}

	public void setSelectedMonthCourse(CourseCoordinator selectedMonthCourse) {
		this.selectedMonthCourse = selectedMonthCourse;
	}
	
}
