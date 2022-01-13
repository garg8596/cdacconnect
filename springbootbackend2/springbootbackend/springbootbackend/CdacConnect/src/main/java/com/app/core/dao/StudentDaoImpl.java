package com.app.core.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.app.core.pojos.CourseCoordinator;
import com.app.core.pojos.ExternalMarks;
import com.app.core.pojos.InternalMarks;
import com.app.core.pojos.Student;
import com.app.core.pojos.StudentComplaints;
import com.app.core.pojos.StudentNotices;
import com.app.core.pojos.StudentOfTheMonth;


@Repository

public class StudentDaoImpl implements IStudent {

	
	@PersistenceContext
	private EntityManager mgr;
	
	
	public StudentDaoImpl() {
		super();
	}


	@Override
	public Student validateStudentLogin(int studentPrn, String studentPassword) {
		String jpql = "select stud from Student stud where studentPrn=:prn and password=:pass";
		//Student ss=mgr.unwrap(Session.class).get(Student.class,studentPrn);
		//return  ss;
		return  mgr.unwrap(Session.class).
				createQuery(jpql, Student.class).setParameter("prn",studentPrn).setParameter("pass",studentPassword).getSingleResult();
	}
	
	@Override
	public Student validateSecurityQuestion(int studentPrn, String email, LocalDate dataOfBirth) {
		String jpql = "select stud from Student stud where studentPrn=:prn and email=:email and dateofbirth=:dob";
		return mgr.unwrap(Session.class).
				createQuery(jpql, Student.class).setParameter("prn",studentPrn).setParameter("email",email).setParameter("dob",dataOfBirth).getSingleResult();
	}
	@Override
	public Student insertStudentDetails(Student stud) {
		mgr.unwrap(Session.class).persist(stud);
		return stud;
	}
	@Override
	public Student updateNewpassword(Student stud) {
		mgr.unwrap(Session.class).update(stud);
		
		
		return stud;
	}
	@Override
	public List<StudentNotices> getListofNoticeActive() {
		String jpql = "select studentnotices from StudentNotices studentnotices";
		return mgr.unwrap(Session.class).
				createQuery(jpql, StudentNotices.class).getResultList();
	}
	@Override
	public List<Student> getStudents() {
		String jpql = "select cc from  Student cc";
		return mgr.unwrap(Session.class).
				createQuery(jpql, Student.class).getResultList();

	}
	
	
	
	@Override
	public Student getStudentDetails(int studentPrn) {
		//String jpql = "select cc from  Student cc where studentprn=:courseId";
	//	return mgr.unwrap(Session.class).
		//		createQuery(jpql, Student.class).setParameter("courseId",studentPrn).getSingleResult();

		Student ss=mgr.unwrap(Session.class).get(Student.class,studentPrn);
		return  ss;
	}
	@Override
	public List<StudentNotices> getStudentNotices() {
		String jpql = "select studnotices from StudentNotices studnotices";
		return  mgr.createQuery(jpql, StudentNotices.class).getResultList() ;
	}
	@Override
	public List<StudentOfTheMonth> getStomDetails() {
		String jpql = "select studstom  from StudentOfTheMonth studstom ";
		return  mgr.createQuery(jpql,StudentOfTheMonth.class).getResultList() ;
	}
	@Override
	public StudentComplaints insertComplaints(StudentComplaints sc) {
		
		mgr.unwrap(Session.class).persist(sc);
		return sc;
	}
	@Override
	public List<StudentComplaints> viewComplaints(int studentPrn) {
	
		String jpql="select studcomp from StudentComplaints studcomp where studentPrn=:prn";
		return mgr.unwrap(Session.class).
				createQuery(jpql, StudentComplaints.class).setParameter("prn",studentPrn).getResultList();
	}
	@Override
	public boolean removeComplaints(StudentComplaints scom) {
		 
		mgr.unwrap(Session.class).delete(scom);
		return true;
	}
	@Override
	public StudentComplaints getComplaint(int complaintId) {
		
		
		return mgr.unwrap(Session.class).get(StudentComplaints.class, complaintId) ;
	}
	
	@Override
	public StudentComplaints updateComplaint(StudentComplaints scomp) {
		
		mgr.unwrap(Session.class).update(scomp);
		
		return scomp ;
	}


	@Override
	public StudentNotices getNoticesDetails(int noticeId) {
		
		return mgr.unwrap(Session.class).get(StudentNotices.class,noticeId);
	}


	@Override
	public StudentComplaints getComplaintsDetails(int complaintId) {
		
		return mgr.unwrap(Session.class).get(StudentComplaints.class,complaintId);
	}


	@Override
	public List<StudentComplaints> getAllComplaints() {
		
		String jpql="select studcomp from StudentComplaints studcomp ";
		return mgr.unwrap(Session.class).
				createQuery(jpql, StudentComplaints.class).getResultList(); 
	}


	@Override
	public InternalMarks internalMarkData(InternalMarks internalmark) {
		
		mgr.unwrap(Session.class).persist(internalmark);
		return  internalmark;
	}


	@Override
	public StudentNotices viewNotices(Integer noticeId) {
		return mgr.unwrap(Session.class).get(StudentNotices.class,noticeId);
	
	}


	@Override
	public StudentComplaints updateStudentStatus(StudentComplaints sc) {
		
		mgr.unwrap(Session.class).update(sc);
		return  sc;
	}


	@Override
	public StudentOfTheMonth getStom(Integer stomId) {
		
		return mgr.unwrap(Session.class).get(StudentOfTheMonth.class,stomId);
	}


	@Override
	public StudentNotices removeNotice(StudentNotices studNot) {
		
		mgr.unwrap(Session.class).remove(studNot);
		return  studNot;
	}


	@Override
	public InternalMarks insertInternalMarks(InternalMarks inmark) {
		
		 mgr.unwrap(Session.class).persist(inmark);
		 return inmark;
	}


	@Override
	public ExternalMarks insertExternalMarks(ExternalMarks ext) {
		
		 mgr.unwrap(Session.class).persist(ext);
		 return ext;
	}


@Override
	public List<InternalMarks> listInternalMarks(Student stud) {
		String jpql="select inmark from InternalMarks inmark  where studentmarks=:stud ORDER BY subjectName ";
		return mgr.unwrap(Session.class).
				createQuery(jpql, InternalMarks.class).setParameter("stud", stud).getResultList(); 
	}


@Override
public List<ExternalMarks> listExternalMarks(Student studentmarks) {
	String jpql="select exmark from ExternalMarks exmark  where studentexternalmarks=:stud  ORDER BY subjectName";
	return mgr.unwrap(Session.class).
			createQuery(jpql, ExternalMarks.class).setParameter("stud", studentmarks).getResultList(); 
	
	
}


@Override
public Student updateStudentDetails(Student stud) {
	 mgr.unwrap(Session.class).persist(stud);
	return stud;
}
@Override
public Student updateStudentDe(Student stud) {
	 mgr.unwrap(Session.class).merge(stud);
	return stud;
}



@Override
public Student validateEmail(String email) {
	
	String jpql = "select stud from Student stud where  email=:email ";
	return mgr.unwrap(Session.class).
			createQuery(jpql, Student.class).setParameter("email",email).getSingleResult();

}



	

}
