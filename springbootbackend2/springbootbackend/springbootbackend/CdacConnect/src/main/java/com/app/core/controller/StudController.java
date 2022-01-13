package com.app.core.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.core.pojos.Student;
import com.app.core.service.IStudentService;

@RestController // =@Controller+@ResponseBody
//on all ret types of req handling methods.
@RequestMapping("/Stud")
 // origins=*

public class StudController {

	@Autowired
	private IStudentService sservice;

	public StudController() {
		super();
	}
	
		@PostConstruct
	public void init() {
		System.out.println("in init " + sservice);
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<?> validateLogin(@RequestParam int studentPrn) 
	{
		System.out.println(" Student dtls " + studentPrn);
     //     Student studDetails = sservice.validateStudentLogin(studentPrn, studentPassword);
	//	if (studDetails == null)
			//return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Student>(sservice.validateStudentLogin(studentPrn,"12345678"), HttpStatus.OK);
	}
	
	


}
