package com.app.core.controller;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.core.dao.IStudent;
import com.app.core.pojos.Complaint;
import com.app.core.pojos.CourseCoordinator;
import com.app.core.pojos.ExamStatus;
import com.app.core.pojos.ExternalMarks;
import com.app.core.pojos.Gender;
import com.app.core.pojos.InternalMarks;
import com.app.core.pojos.Student;
import com.app.core.pojos.StudentComplaints;
import com.app.core.pojos.StudentNotices;
import com.app.core.pojos.StudentOfTheMonth;
import com.app.core.pojos.StudentStatus;
import com.app.core.service.IStudentService;

@RestController // =@Controller+@ResponseBody
//on all ret types of req handling methods.
@RequestMapping("/Studentmapping")
 // origins=*
@CrossOrigin
public class StudentController {
	
	@Autowired
	private IStudentService sservice;
	
	@PostConstruct
	public void init() {
		System.out.println("in init " + sservice);
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<?> validateLogin(@RequestBody Student studentdetails) 
	{
		Student stud=sservice.getStudentDetails(studentdetails.getStudentPrn());
		if(stud.getStudentStatus()==StudentStatus.unverified)
		{
			return new ResponseEntity<String>("Not verified yet",HttpStatus.NOT_ACCEPTABLE);
			
		}
		else
		{
			Student st=new Student();
		st.setStudentPrn(studentdetails.getStudentPrn());
		st.setPassword(studentdetails.getPassword());
		
		System.out.println(" Student dtls " + st.getStudentPrn());
      try {
		Student studDetails = sservice.validateStudentLogin(st.getStudentPrn(),st.getPassword());
      //    Student studDetails = sservice.validateStudentLogin(190170,"12345678");
      	
            return new ResponseEntity<Student>(studDetails, HttpStatus.OK);
      		}catch(Exception e)
      {
      			return new ResponseEntity<String>("Invalid ID or Password",HttpStatus.NOT_ACCEPTABLE);
      			}
      }
      
	}
/*	@PostMapping("/login")
	public ResponseEntity<?> validateLogin(@RequestBody Student studentdetails) 
	{
		System.out.println(" Student dtls " + studentdetails.getStudentPrn());
          Student studDetails = sservice.validateStudentLogin(studentdetails.getStudentPrn(), studentdetails.getPassword());
		if (studDetails == null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Student>(studDetails, HttpStatus.OK);
	}*/
	
	@PostMapping("/verify")
	public ResponseEntity<?> getSecurityVerify(@RequestBody Student stud) {
	//	Logger logger = LoggerFactory.getLogger(this.getClass());
		System.out.println("get emp dtls ");
	    
	    try {
			Student studt=sservice.validateSecurityQuestion(stud.getStudentPrn(),stud.getEmail(),stud.getDateofbirth());
			return new ResponseEntity<Student>(studt, HttpStatus.OK);
		} catch (Exception e1) {
			e1.printStackTrace();// only for debugging
			return new ResponseEntity<Student>(stud,HttpStatus.NOT_ACCEPTABLE);
		}

    
	}
	
	
	@PostMapping("/validateemailstudent")
	public ResponseEntity<?> validateEmail(@RequestBody String email) {
	//	Logger logger = LoggerFactory.getLogger(this.getClass());
		System.out.println("get emp dtls ");
	    
	    try {
			Student studt=sservice.validateEmail(email);
			return new ResponseEntity<Student>(studt, HttpStatus.OK);
		} catch (Exception e1) {
			e1.printStackTrace();// only for debugging
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

    
	}
	@PostMapping("/register")
	public ResponseEntity<?> saveStudentDtls(@RequestBody Student stud)
	{
		
      
  //    stud.setCourseName("DAC");
      //stud.setStudentGender(Gender.valueOf(stud.getStudentGender()));
      stud.setRegistrationDate(LocalDate.now());
      stud.setStudentStatus(StudentStatus.unverified);
		
		try {
			
			
			return new ResponseEntity<Student>(sservice.insertStudentDetails(stud), HttpStatus.OK);
		} catch (Exception e1) {
			e1.printStackTrace();// only for debugging
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

      }

	
/*
    @PutMapping("/update")
	public ResponseEntity<?> updatePassword( @RequestParam int studentPrn,@RequestParam String studentPassword) {
		System.out.println("in save student " + studentPrn + " " );

		try {
			Student stud=sservice.getStudentDetails(studentPrn) ;
			stud.setPassword(studentPassword);
			return new ResponseEntity<Student>(sservice.insertStudentDetails(stud), HttpStatus.OK);
		} catch (Exception e1) {
			e1.printStackTrace();// only for debugging
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
   */ 
    @GetMapping("/getListOfNotice")
    public ResponseEntity<?>  getListOfNotice() {
		System.out.println("in Notice student " +  " " );

		try {
			
			return new ResponseEntity<List<StudentNotices>>(sservice.getListofNoticeActive(), HttpStatus.OK);
		} catch (Exception e1) {
			e1.printStackTrace();// only for debugging
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	} 
    
    @PostMapping("/deletenotice")	
	  public ResponseEntity<?> deleteNotices(@RequestBody Integer noticeId) {
			
			System.out.println("get Student notices dtls ");
		    
		    try {
		    
				StudentNotices studNot=sservice.getNoticesDetails(noticeId);
				StudentNotices studdel=sservice.removeNotice(studNot);
					
				return new ResponseEntity<StudentNotices>(studdel, HttpStatus.OK);
			} catch (Exception e1) {
				e1.printStackTrace();// only for debugging
				return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
	  }
    
    @GetMapping("/getListOfStom")
    public ResponseEntity<?>  getListofStom() {
    	
	System.out.println("in Stom student " +  " " );

	try {
		
		return new ResponseEntity<List<StudentOfTheMonth>>(sservice.getStomDetails(), HttpStatus.OK);
	} catch (Exception e1) {
		e1.printStackTrace();// only for debugging
		return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
   
    
  
   
    
    @PostMapping("/insertcomplaints")
    public ResponseEntity<?> insertComplaints(@RequestBody StudentComplaints studcomp)   {
		System.out.println("in save student complaints " );

		try {
                    studcomp.setComplaintDate(LocalDate.now());
                    studcomp.setComplaintStatus(Complaint.Active);
			return new ResponseEntity<StudentComplaints>(sservice.insertComplaints(studcomp), HttpStatus.OK);
		} catch (Exception e1) {
			e1.printStackTrace();// only for debugging
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
    
    @GetMapping("/getAllComplaints")
    public ResponseEntity<?>  getAllComplaints() {
    	
	System.out.println("in viewALLComplaint student " +  " " );

	//int studentPrn=190145;
	try {
		
		return new ResponseEntity<List<StudentComplaints>>(sservice.getAllComplaints(), HttpStatus.CREATED);
	} catch (Exception e1) {
		e1.printStackTrace();// only for debugging
		return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}  

    
    @PostMapping("/viewComplaints")
    public ResponseEntity<?>  viewComplaints(@RequestBody int studentPrn) {
    	
	System.out.println("in viewComplaint student " +  " " );

	//int studentPrn=190145;
	try {
		
		return new ResponseEntity<List<StudentComplaints>>(sservice.viewComplaints(studentPrn), HttpStatus.CREATED);
	} catch (Exception e1) {
		e1.printStackTrace();// only for debugging
		return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
    
  
    @GetMapping("/removeComplaints/{complaintId}")
    public ResponseEntity<?>  removeComplaints(int complaintId) {
    	
	System.out.println("in removeComplaint student " +  " " );
           
	try {
		StudentComplaints st=sservice.getComplaint(complaintId);
		return new ResponseEntity<Boolean>(sservice.removeComplaints(st),HttpStatus.OK);
	} catch (Exception e1) {
		e1.printStackTrace();// only for debugging
		return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}  

    @PostMapping("/updatecomplaints")
    public ResponseEntity<?> updateComplaints( @RequestParam int complaintId,@RequestParam int prn,@RequestParam String complaintSubjectName,@RequestParam String complaintDescription,@RequestParam LocalDate complaintDate)
    {
		System.out.println("in save student " + prn + " " );

		try {
			StudentComplaints st=sservice.getComplaint(complaintId);
			st.setComplaintSubjectName(complaintSubjectName);
			st.setComplaintDescription(complaintDescription);
			st.setComplaintDate(complaintDate);
					
			return new ResponseEntity<StudentComplaints>(sservice.updateComplaint(st), HttpStatus.CREATED);
		} catch (Exception e1) {
			e1.printStackTrace();// only for debugging
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
    
    
@PostMapping("/viewNoticesDetails")
    
    public ResponseEntity<?> viewNoticesDetails(@RequestBody Integer noticeId )  {
    			
    			System.out.println("get StudentPrn dtls " +  noticeId);
    	System.out.println("get StudentPrn dtls " );
	    
    		    try {
    		    
    				StudentNotices ss= sservice.getNoticesDetails(noticeId);
    				
    				return new ResponseEntity<StudentNotices>(ss, HttpStatus.OK);
    			} catch (Exception e1) {
    				e1.printStackTrace();// only for debugging
    				return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
    			}

    	    
    		} 

    @PostMapping("/studentdetails")
    
    public ResponseEntity<?> getStudentDetails(@RequestBody Integer studentPrn)  {
    			
    			System.out.println("get StudentPrn dtls " + studentPrn);
    	System.out.println("get StudentPrn dtls " );
	    
    		    try {
    		    
    				Student ss= sservice.getStudentDetails(studentPrn);
    				
    				return new ResponseEntity<Student>(ss, HttpStatus.OK);
    			} catch (Exception e1) {
    				//e1.printStackTrace();// only for debugging
    				return new ResponseEntity<String>("Student Prn is not found",HttpStatus.NOT_ACCEPTABLE);
    			}

    	    
    		} 
    
//    updatestudentdetails
 @PostMapping("/updatestudentdetails")
      public ResponseEntity<?> updatestudentdetails(@RequestBody Integer studentPrn)  {
    			
    			System.out.println("get StudentPrn dtls " + studentPrn);
    	System.out.println("get StudentPrn dtls " );
	    
    		    try {
    		    
    				Student ss= sservice.getStudentDetails(studentPrn);
    				ss.setStudentStatus(StudentStatus.verified);
    				Student stud=sservice.updateStudentDetails(ss);
    				return new ResponseEntity<Student>(stud, HttpStatus.OK);
    			} catch (Exception e1) {
    				e1.printStackTrace();// only for debugging
    				return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
    			}

    	    
    		} 
 
 
 @PostMapping("/updatestudentdet")
 public ResponseEntity<?> updatestudentde(@RequestBody Student studentd)  {
			
			
	System.out.println("get StudentPrn dtls " );
   
		    try {
		    
				Student ss= sservice.getStudentDetails(studentd.getStudentPrn());
				  ss.setPassword(studentd.getPassword());
				Student stud=sservice.updateStudentDe(ss);
				return new ResponseEntity<Student>(stud, HttpStatus.OK);
			} catch (Exception e1) {
				e1.printStackTrace();// only for debugging
				return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
			}

	    
		} 
    
    
    @GetMapping("/studentalldetails")
    public ResponseEntity<?> getALLStudentDetails()  {
    			
    			System.out.println("get StudentPrn dtls ");
    		    
    		    try {
    		    
    				
    				return new ResponseEntity<List<Student>>(sservice.getStudents(), HttpStatus.OK);
    			} catch (Exception e1) {
    				e1.printStackTrace();// only for debugging
    				return new ResponseEntity<String>("Student details not found",HttpStatus.INTERNAL_SERVER_ERROR);
    			}

    	    
    		} 

    
@PostMapping("/viewComplaintsDetails")
    
    public ResponseEntity<?> viewComplaintDetails(@RequestBody Integer studentComplaintId )  {
    			
    			System.out.println("get StudentPrn dtls " +  studentComplaintId);
    	System.out.println("get StudentPrn dtls " );
	    
    		    try {
    		    
    				StudentComplaints ss= sservice.getComplaintsDetails(studentComplaintId);
    				
    				return new ResponseEntity<StudentComplaints>(ss, HttpStatus.OK);
    			} catch (Exception e1) {
    				e1.printStackTrace();// only for debugging
    				return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
    			}

    	    
    		} 

@PostMapping("/internalMarks")
public ResponseEntity<?>  internalMarkSubmit(@RequestBody InternalMarks  internalmark) {
	//internalmark.ickey(internalmark.ge)
	
	System.out.println(internalmark);
System.out.println("in Internal Student student " +  " " +internalmark );

;
try {
	
	return new ResponseEntity<InternalMarks>(sservice.internalMarkData(internalmark), HttpStatus.CREATED);
} catch (Exception e1) {
	e1.printStackTrace();// only for debugging
	return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
}

}  
@PostMapping("/updateStudentStatus")
	 public ResponseEntity<?>  updateStudentStatus(@RequestBody Integer studentComplaintId )  {
			
			System.out.println("get StudentPrn dtls " +  studentComplaintId);
	System.out.println("get StudentPrn dtls " );
 
		    try {
		    
				StudentComplaints ss= sservice.getComplaintsDetails(studentComplaintId);
				ss.setComplaintStatus(Complaint.Unactive);
				StudentComplaints stud= sservice.getComplaintsDetails(studentComplaintId);
				
				return new ResponseEntity<StudentComplaints>(stud, HttpStatus.OK);
			} catch (Exception e1) {
				e1.printStackTrace();// only for debugging
				return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
			}

	    
		}

@PostMapping("/getstom")
public ResponseEntity<?>  getStomDetail(@RequestBody Integer stomId)  {
		
		System.out.println("get stomId dtls " +  stomId);
System.out.println("get StudentPrn dtls " );

	    try {
	    
				StudentOfTheMonth studmonth=sservice.getStom(stomId);
			return new ResponseEntity<StudentOfTheMonth>(studmonth, HttpStatus.OK);
		} catch (Exception e1) {
			e1.printStackTrace();// only for debugging
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

   
	} 

@PostMapping("/listofthedata")
public ResponseEntity<?>  insertInternalMarks(@RequestBody InternalMarks  inm)  {
	
	
	System.out.println("get stomId dtls " );
System.out.println("get StudentPrn dtls " );

  inm.setStudentStatus(ExamStatus.Passed);


//inm.setSubjectName("Java");
//InternalMarks inmark =new InternalMarks(inm.getSubjectName(),inm.getLabInternal(),inm.getLabExam(),ExamStatus.Passed); 
//inm.setStudentStatus(ExamStatus.Passed);
//inmark.setStudentmarks(inm.getStudentmarks());
    try {
    
		InternalMarks inmarks=sservice.insertInternalMarks(inm);
		return new ResponseEntity<InternalMarks>(inmarks, HttpStatus.OK);
	} catch (Exception e1) {
		e1.printStackTrace();// only for debugging
		return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

    @PostMapping("/listexternaldata")
    public ResponseEntity<?>  insertExternalMarks(@RequestBody ExternalMarks  ext)  {
    	
    	
    	System.out.println("get stomId dtls " );
    System.out.println("get StudentPrn dtls " );


    //inm.setSubjectName("Java");
    //InternalMarks inmark =new InternalMarks(inm.getSubjectName(),inm.getLabInternal(),inm.getLabExam(),ExamStatus.Passed); 
   
   
     ext.setStudentStatus(ExamStatus.Passed);
   
  
   //inmark.setStudentmarks(inm.getStudentmarks());
        try {
        
    		ExternalMarks extmarks=sservice.insertExternalMarks(ext);
    		return new ResponseEntity<ExternalMarks>(extmarks, HttpStatus.OK);
    	} catch (Exception e1) {
    		e1.printStackTrace();// only for debugging
    		return new ResponseEntity<String>("Not found",HttpStatus.INTERNAL_SERVER_ERROR);
    	}

} 
    
    @PostMapping("/listofthemark")
    public ResponseEntity<?>  listInternalMarks(@RequestBody Student  studentmarks)  {
    	
    	
    	System.out.println("get stomId dtls " );
    System.out.println("get StudentPrn dtls " );


    //inm.setSubjectName("Java");
    //InternalMarks inmark =new InternalMarks(inm.getSubjectName(),inm.getLabInternal(),inm.getLabExam(),ExamStatus.Passed); 
    //inmark.setStudentmarks(inm.getStudentmarks());
        try {
        
    		List<InternalMarks> inmarks=sservice.listInternalMarks(studentmarks);
    		return new ResponseEntity<List<InternalMarks>>(inmarks, HttpStatus.OK);
    	} catch (Exception e1) {
    		e1.printStackTrace();// only for debugging
    		return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
    
    @PostMapping("/listoftheextmark")
    public ResponseEntity<?>  listExternalMarks(@RequestBody Student  studentmarks)  {
    	
    	
    	System.out.println("get stomId dtls " );
    System.out.println("get StudentPrn dtls " );


    //inm.setSubjectName("Java");
    //InternalMarks inmark =new InternalMarks(inm.getSubjectName(),inm.getLabInternal(),inm.getLabExam(),ExamStatus.Passed); 
    //inmark.setStudentmarks(inm.getStudentmarks());
        try {
        
    		List<ExternalMarks> exmarks=sservice.listExternalMarks(studentmarks);
    		return new ResponseEntity<List<ExternalMarks>>(exmarks, HttpStatus.OK);
    	 } catch (Exception e1) {
    		e1.printStackTrace();// only for debugging
    		return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
    




    
}
