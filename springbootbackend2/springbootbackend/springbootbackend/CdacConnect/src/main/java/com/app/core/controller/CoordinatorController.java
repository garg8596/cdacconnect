package com.app.core.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.annotation.PostConstruct;

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

import com.app.core.pojos.Complaint;
import com.app.core.pojos.CourseCoordinator;
import com.app.core.pojos.Coursecoordinatorcomplaints;
import com.app.core.pojos.Student;
import com.app.core.pojos.StudentNotices;
import com.app.core.pojos.StudentOfTheMonth;
import com.app.core.service.ICoordinatorService;
import com.app.core.service.IStudentService;

@RestController // =@Controller+@ResponseBody
//on all ret types of req handling methods.
@RequestMapping("/CourseCoordinator")
@CrossOrigin // origins=*
public class CoordinatorController {

	
@Autowired
 private ICoordinatorService cservice;
@Autowired IStudentService sservice;
	@PostConstruct
	public void init() {
		System.out.println("in init " + cservice);
	}
	//done
	@PostMapping("/login")
	public ResponseEntity<?> validateLogin(@RequestBody CourseCoordinator  ccordinator ) {
		
		CourseCoordinator cc=new CourseCoordinator();
		cc.setCourseId(ccordinator.getCourseId());
		cc.setCoordinatorPassword(ccordinator.getCoordinatorPassword());
		try {
			System.out.println(" Corrdinator dtls " + ccordinator.getCourseId());
          CourseCoordinator CoordinatorDetails = cservice.ValidateLogin(ccordinator.getCourseId(),ccordinator.getCoordinatorPassword());
  		return new ResponseEntity<CourseCoordinator>(CoordinatorDetails, HttpStatus.OK);

		}catch(Exception e)
		{
		return new ResponseEntity<String>("Not found coordinator",HttpStatus.NOT_FOUND);
		
	}
	//	return new ResponseEntity<String>("Not found coordinator",HttpStatus.NOT_FOUND);
	}
	
	//
	@PostMapping("/verify")
	public ResponseEntity<?> getSecurityVerify(@RequestBody CourseCoordinator ccd) {
	//	System.out.println("get course dtls " + courseId);
	    
	    try {
			CourseCoordinator cdetails=cservice.validateSecurityQustion(ccd.getCourseId(), ccd.getCordinatorEmail(),ccd.getCoordinatorDateofbirth());
			return new ResponseEntity<CourseCoordinator>(cdetails, HttpStatus.OK);
		} catch (Exception e1) {
			e1.printStackTrace();// only for debugging
			return new ResponseEntity<String>("Not found",HttpStatus.INTERNAL_SERVER_ERROR);
		}

    
	}
	 @PutMapping("/update")
		public ResponseEntity<?> updatePassword( @RequestParam int courseId,@RequestParam String coordinatorPassword) {
			System.out.println("in  courseId " + courseId + " " );

			try {
				CourseCoordinator coordinator=cservice.getCoordintorDetails(courseId) ;
				coordinator.setCoordinatorPassword(coordinatorPassword);
				return new ResponseEntity<CourseCoordinator>(cservice.updateNewpassword(coordinator), HttpStatus.OK);
			} catch (Exception e1) {
				e1.printStackTrace();// only for debugging
				return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
	
}
	 //done
		@PostMapping("/notices")
		public ResponseEntity<?> insertNoticeDetails(@RequestBody StudentNotices studNot) {
			System.out.println("get complaintas dtls ");
	        studNot.setPublishedDate(LocalDate.now());  
			
		    try {
		    
				StudentNotices snotices=cservice.insertNotice(studNot);
				return new ResponseEntity<StudentNotices>(snotices, HttpStatus.OK);
			} catch (Exception e1) {
				e1.printStackTrace();// only for debugging
				return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
			}

	    
		}//done
		
		
		@PutMapping("/updatenotices")
		public ResponseEntity<?> updateNoticeDetails(@RequestBody StudentNotices studNot) {
			System.out.println("get complaintas dtls ");
			
			
	       
		    try {
		    	StudentNotices snot=sservice.getNoticesDetails(studNot.getNoticeId()); 
				
				 snot.setPublishedDate(LocalDate.now());  
					
			        snot.setPublishedBy(studNot.getPublishedBy());
					snot.setDescription(studNot.getDescription());
					snot.setTitle(studNot.getTitle());
					snot.setSelectedCourseNotice(studNot.getSelectedCourseNotice());
					StudentNotices snotices=cservice.updateNotice(snot);
				return new ResponseEntity<StudentNotices>(snotices, HttpStatus.OK);
			} catch (Exception e1) {
				e1.printStackTrace();// only for debugging
				return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
			}

	    
		}//done
		
//		@PostMapping("/viewnotices")
//		public ResponseEntity<?>  viewNotices(@RequestBody Integer noticeId  ) {
//			System.out.println("get complaintas dtls ");
//	        
//		    try {
//		    
//				return new ResponseEntity<StudentNotices>(snotices, HttpStatus.OK);
//			} catch (Exception e1) {
//				e1.printStackTrace();// only for debugging
//				return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
//			}

	    
		//}//done
		
		@PostMapping("/insertrplyComplaint")
		public ResponseEntity<?> insertrplyComplaint(@RequestBody Coursecoordinatorcomplaints ccc) {
			System.out.println("get complaintas dtls ");
	        ccc.setCoordinatorPostDate(LocalDate.now());
	        ccc.setCoordinatorComplaintStatus(Complaint.Unactive);
			
		    try {
		    
				Coursecoordinatorcomplaints cccomplaints=cservice.insertReplyComplaint(ccc);
				return new ResponseEntity<Coursecoordinatorcomplaints>(cccomplaints, HttpStatus.OK);
			} catch (Exception e1) {
				e1.printStackTrace();// only for debugging
				return new ResponseEntity<Coursecoordinatorcomplaints>(ccc,HttpStatus.INTERNAL_SERVER_ERROR);
			}

	    
		}
		
	
		
		@PostMapping("/sotm")
		public ResponseEntity<?> insertStomDetails(@RequestBody StudentOfTheMonth studmonth) {
			
			System.out.println("get Student prn in studentmonth dtls ");
		    
		    try {
		    
				StudentOfTheMonth sotm=cservice.insertStomDetails(studmonth);
				return new ResponseEntity<StudentOfTheMonth>(sotm, HttpStatus.OK);
			} catch (Exception e1) {
				e1.printStackTrace();// only for debugging
				return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
			}

	    
		}
		
		@PostMapping("/updatesotm")
		public ResponseEntity<?> updateStomDetails(@RequestBody StudentOfTheMonth studmonth) {
			
			System.out.println("get Student prn in studentmonth dtls ");
		    
			
		    try {
		    	StudentOfTheMonth sotm= sservice.getStom(studmonth.getStomId());
		    	sotm.setDescription(studmonth.getDescription());
		    	sotm.setMonthName(studmonth.getMonthName());
		    	sotm.setStudentprn(studmonth.getStudentprn());
				StudentOfTheMonth sotmdetails=cservice.updateStomDetails(studmonth);
				return new ResponseEntity<StudentOfTheMonth>(sotmdetails, HttpStatus.OK);
			} catch (Exception e1) {
				e1.printStackTrace();// only for debugging
				return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
			}

	    
		}
		//done
		@GetMapping("/coordintor/{courseid}")
public ResponseEntity<?> getcoordinatorDetails(@PathVariable int courseid)  {
			
			System.out.println("get course dtls " + courseid);
		    
		    try {
		    
				CourseCoordinator cc=cservice.getCoordintorDetails(courseid);
				return new ResponseEntity<CourseCoordinator>(cc, HttpStatus.OK);
			} catch (Exception e1) {
				e1.printStackTrace();// only for debugging
				return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
			}

	    
		} 
		@PostMapping("/coordintordeatils")
		public ResponseEntity<?> getcoordinatorDetails(@RequestBody Integer courseId)  {
					
					System.out.println("get course dtls " + courseId);
				    
				    try {
				    
						CourseCoordinator cc=cservice.getCoordintorDetails(courseId);
						return new ResponseEntity<CourseCoordinator>(cc, HttpStatus.OK);
					} catch (Exception e1) {
						e1.printStackTrace();// only for debugging
						return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
					}
		}
	
		@PostMapping("/forgotCoordinatorPassword")
		public ResponseEntity<?> forgotPassword(@RequestBody CourseCoordinator cpwd) {
			
			System.out.println("in coordinator forgotpwd");
			 try {
				// CourseCoordinator coursecc=
				    
					CourseCoordinator cc=cservice.getCoordintorDetails(cpwd.getCourseId());
					cc.setCoordinatorPassword(cpwd.getCoordinatorPassword());
					
					
					return new ResponseEntity<CourseCoordinator>(cservice.updateNewPassword(cc), HttpStatus.OK);
				} catch (Exception e1) {
					e1.printStackTrace();// only for debugging
					return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
				}
			
			
		}
}
