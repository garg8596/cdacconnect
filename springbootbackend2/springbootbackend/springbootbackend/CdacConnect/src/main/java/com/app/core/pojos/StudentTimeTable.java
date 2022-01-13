package com.app.core.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="StudentTimeTable")
public class StudentTimeTable   {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty(value = "timetableid")
	public Integer timeTableId;
	@Column(nullable = false)
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="IST")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate scheduledate;
	@Column()
	public String type;
	@Column
	public String moduleName;
	@Column
	public String facultyName;
	@Column
	public String venue;
	@Column
	public String timing;
	
	public StudentTimeTable() {
		super();
	}

	public StudentTimeTable(LocalDate scheduledate, String type, String moduleName, String facultyName, String venue,
			String timing) {
		super();
		this.scheduledate = scheduledate;
		this.type = type;
		this.moduleName = moduleName;
		this.facultyName = facultyName;
		this.venue = venue;
		this.timing = timing;
	}

	@Override
	public String toString() {
		return "StudentTimeTable [timeTableId=" + timeTableId + ", scheduledate=" + scheduledate + ", type=" + type
				+ ", moduleName=" + moduleName + ", facultyName=" + facultyName + ", venue=" + venue + ", timing="
				+ timing + "]";
	}

	public Integer getTimeTableId() {
		return timeTableId;
	}

	public void setTimeTableId(Integer timeTableId) {
		this.timeTableId = timeTableId;
	}

	public LocalDate getScheduledate() {
		return scheduledate;
	}

	public void setScheduledate(LocalDate scheduledate) {
		this.scheduledate = scheduledate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getTiming() {
		return timing;
	}

	public void setTiming(String timing) {
		this.timing = timing;
	}
	
	
	
	
	
}
