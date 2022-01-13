package com.app.core.dao;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.app.core.pojos.CourseCoordinator;
import com.app.core.pojos.Coursecoordinatorcomplaints;
import com.app.core.pojos.Student;
import com.app.core.pojos.StudentNotices;
import com.app.core.pojos.StudentOfTheMonth;


@Repository
public class CoordinatorDaoImpl implements ICoordinator {
	
	@PersistenceContext
	private EntityManager mgr;

	@Override
	public CourseCoordinator ValidateLogin(int courseId, String password) {
		String jpql = "select cc from  CourseCoordinator cc where courseId=:courseId and coordinatorPassword=:pass";
		return mgr.unwrap(Session.class).
				createQuery(jpql, CourseCoordinator.class).setParameter("courseId",courseId).setParameter("pass",password).getSingleResult();

	}

	@Override
	public CourseCoordinator validateSecurityQustion(int courseId, String email, LocalDate dataOfBirth) {
		String jpql = "select cc from  CourseCoordinator cc where courseId=:courseId and  cordinatorEmail=:email and coordinatorDateofbirth=:dob";
		
		return   mgr.unwrap(Session.class).
				createQuery(jpql, CourseCoordinator.class).setParameter("courseId",courseId).setParameter("email",email).setParameter("dob",dataOfBirth).getSingleResult();

		
	}

	@Override
	public CourseCoordinator updateNewpassword(CourseCoordinator cord) {
		mgr.unwrap(Session.class).update(cord);	
		return cord;
	}

	@Override
	public StudentNotices insertNotice(StudentNotices notices) {
		mgr.unwrap(Session.class).persist(notices);		
		return  notices;
	}

	@Override
	public Coursecoordinatorcomplaints insertReplyComplaint(Coursecoordinatorcomplaints complaints) {
		mgr.unwrap(Session.class).persist(complaints);
		return  complaints;
	}

	@Override
	public Coursecoordinatorcomplaints viewComplaint(int complaintId) {
		String jpql = "select ccc from  Coursecoordinatorcomplaints ccc where complaintId=:complaintId";
		return mgr.unwrap(Session.class).
				createQuery(jpql,Coursecoordinatorcomplaints.class).setParameter("complaintId",complaintId).getSingleResult();

	}

	@Override
	public CourseCoordinator getCoordintorDetails(int courseId) {
		String jpql = "select cc from  CourseCoordinator cc where courseId=:courseId";
//		return mgr.unwrap(Session.class).
				//createQuery(jpql, CourseCoordinator.class).setParameter("courseId",courseId).getSingleResult();
		return mgr.unwrap(Session.class).get(CourseCoordinator.class, courseId);
	}
	
	public StudentOfTheMonth insertStomDetails(StudentOfTheMonth stom)
	{
      mgr.unwrap(Session.class).persist(stom);		
	return  stom;
		
	
	}

	@Override
	public boolean removeNotice(StudentNotices notice) {
		mgr.unwrap(Session.class).delete(notice);
		return false;
	}

	@Override
	public StudentNotices updateNotice(StudentNotices notice) {
		mgr.unwrap(Session.class).merge(notice);
		return notice;
	}

	@Override
	public StudentOfTheMonth updateStomDetails(StudentOfTheMonth studmonth) {
		mgr.unwrap(Session.class).merge(studmonth);
		return studmonth;
	}

	@Override
	public CourseCoordinator updateNewPassword(CourseCoordinator cc) {
		mgr.unwrap(Session.class).merge(cc);
		return cc;
	}
}
