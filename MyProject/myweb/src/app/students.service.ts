import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { INotice } from './notices/notices';
import { IComplaints } from './complaints/complaints';
import { ISOTM } from './sotm/sotm';
import { Notices } from './register/Notices';
import { ICC_SOTM } from './cc-sotm/cc-sotm';
import { ICComplaints } from './cc-complaints/IComplaints';
import { Student } from './student';
import { InternalMark } from './results/InternalMarks';
import { externalMark } from './results/externalMarks';

@Injectable({
  providedIn: 'root'
})
export class StudentsService {

  constructor(private http: HttpClient) { }

  getNotices(): Observable<Notices[]> {
    // return this.http.get<INotice[]>('/assets/data/notices.json');
    return this.http.get<Notices[]>('http://localhost:9670/Studentmapping/getListOfNotice');
  }
  setNewNotices(newNotice) {

    return this.http.post('http://localhost:9670//CourseCoordinator/notices', newNotice).toPromise();
  }

  updateNotices(updateNotice) {

    return this.http.put('http://localhost:9670/CourseCoordinator/updatenotices', updateNotice).toPromise();
  }
  removeNotice(noticeId) {
    console.log("notice" + noticeId);
    return this.http.post('http://localhost:9670/Studentmapping/deletenotice', noticeId).toPromise();
  }

  getComplaints(studentPrn): Observable<IComplaints[]> {

    return this.http.post<IComplaints[]>('http://localhost:9670/Studentmapping//viewComplaints', studentPrn);
  }
  getALLComplaints(): Observable<ICComplaints[]> {
    return this.http.get<ICComplaints[]>('http://localhost:9670/Studentmapping/getAllComplaints');
  }

  setReplyComplaint(complaintrply) {
    return this.http.post("http://localhost:9670/CourseCoordinator/insertrplyComplaint", complaintrply).toPromise();

  }
  updateStudentComplaint(complaintId) {
    return this.http.post("http://localhost:9670/Studentmapping/updateStudentStatus", complaintId).toPromise();

  }

  getComplaintdetails(complaintId) {
    return this.http.post("http://localhost:9670/Studentmapping/viewComplaintsDetails", complaintId).toPromise();
  }



  getViewdetails(noticeId) {
    console.log(noticeId);
    return this.http.post("http://localhost:9670/Studentmapping/viewNoticesDetails", noticeId).toPromise();
  }

  getNewComplaintdetails(studentnewcomp) {
    return this.http.post("http://localhost:9670/Studentmapping/insertcomplaints", studentnewcomp).toPromise();
  }


  getStomData(sotmId) {

    return this.http.post("http://localhost:9670/Studentmapping/getstom", sotmId).toPromise();
  }
  getSotm(): Observable<ISOTM[]> {
    return this.http.get<ISOTM[]>('http://localhost:9670/Studentmapping/getListOfStom');
  }
  getccSotm(): Observable<ICC_SOTM[]> {
    return this.http.get<ICC_SOTM[]>('http://localhost:9670/Studentmapping/getListOfStom');
  }
  setccSotm(sotmdata) {

    return this.http.post("http://localhost:9670/CourseCoordinator/sotm", sotmdata).toPromise();
  }
  updateccSotm(sotmdetail) {

    return this.http.post("http://localhost:9670/CourseCoordinator/updatesotm", sotmdetail).toPromise();
  }


  signin(ccordinator) {
    console.log(ccordinator);
    return this.http.post("http://localhost:9670/CourseCoordinator/login", ccordinator).toPromise();
  }

  signstudent(studentdetails) {
    console.log(studentdetails.studentPrn);
    return this.http.post("http://localhost:9670/Studentmapping/login", studentdetails).toPromise();
  }

  signup(studentdetails) {
    console.log(studentdetails);
    return this.http.post("http://localhost:9670/Studentmapping/register", studentdetails).toPromise();
  }

  ForgotPass(studentdetails) {
    console.log(studentdetails);
    return this.http.post("http://localhost:9670/Studentmapping/verify", studentdetails).toPromise();

  }


  getInternalSubmit(InternalData) {

    console.log(InternalData);
    return this.http.post("http://localhost:9670/Studentmapping/internalMarks", InternalData).toPromise();
  }

  getCoordinatorDetails(ccordinatorId) {
    console.log("service logout");
    return this.http
      .post(
        "http://localhost:9670/CourseCoordinator/coordintordeatils",
        ccordinatorId
      )
      .toPromise();
  }

  UpdateCoordinatorPass(coordinatorDetails) {
    return this.http
      .post(
        "http://localhost:9670/CourseCoordinator/forgotCoordinatorPassword", coordinatorDetails).toPromise();

  }

  getStudentDetails(studentPrn) {
    console.log("studentPrn");
    return this.http
      .post(
        "http://localhost:9670/Studentmapping/studentdetails",
        studentPrn)
      .toPromise();
  }
  validateEmail(studentEmail) {
    return this.http
      .post(
        "http://localhost:9670/Studentmapping/validateemailstudent",
        studentEmail)
      .toPromise();

  }


  updateStudentDetails(studentPrn) {
    console.log("studentPrn");
    return this.http
      .post(
        "http://localhost:9670/Studentmapping/updatestudentdetails",
        studentPrn)
      .toPromise();
  }

  ForgotPasscordinator(item) {
    return this.http.post("http://localhost:9670/CourseCoordinator/verify", item).toPromise();

  }
  updateStudentDet(studentdetails) {
    return this.http
      .post(
        "http://localhost:9670/Studentmapping/updatestudentdet", studentdetails).toPromise();
  }

  getStudents(): Observable<Student[]> {
    console.log("studentPrn");
    return this.http.get<Student[]>("http://localhost:9670/Studentmapping/studentalldetails");
  }

  insertdata(internalmarks) {

    return this.http.post("http://localhost:9670/Studentmapping/listofthedata", internalmarks).toPromise();
  }

  insertexternaldata(externaldata) {

    return this.http.post("http://localhost:9670/Studentmapping/listexternaldata", externaldata).toPromise();

  }


  getinternalMark(studentdetail): Observable<InternalMark[]> {

    return this.http.post<InternalMark[]>("http://localhost:9670/Studentmapping/listofthemark", studentdetail);
  }

  getexternalMark(studentdetail): Observable<externalMark[]> {

    return this.http.post<externalMark[]>("http://localhost:9670/Studentmapping/listoftheextmark", studentdetail);
  }
}



