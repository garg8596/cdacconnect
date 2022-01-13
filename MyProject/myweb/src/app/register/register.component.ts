import { Component, OnInit } from '@angular/core';
import { user } from '../register/user';
import { StudentsService } from '../students.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private service: StudentsService, private router: Router) { }

  userModel = new user(999, '', '', '', 'June 15, 2019', 999);

  ngOnInit() {
    this.service.getCoordinatorDetails(2019068001).then(response => { this.coordinatordetail = response, console.log(response) }
    ).catch(error => { console.log(error) });
    console.log(this.coordinatordetail);



  }

  // register(value)
  // {
  //   console.log(value);

  //   this.service.signup(value).then(response=>{
  //     console.log(response)}).catch(error=>{console.log(error)});
  // }
  coordinatordetail: any;
  signupStudent(value) {
    console.log(value);
    value.courseName = "DAC";
    // getCoordinatorDetails(ccordinatorId)
    this.service.getCoordinatorDetails(2019068001).then(response => { this.coordinatordetail = response, console.log(response) }
    ).catch(error => { console.log(error) });
    console.log(this.coordinatordetail);
    value.selectedCourse = (this.coordinatordetail);
    console.log(value)
    this.service.signup(value).then(response => {
      console.log(response)
    }).catch(error => { console.log(error) });
    this.router.navigate(["/home"]).then(() => {
      window.location.reload();
    });
  }

  gotoHome() {
    this.router.navigate(["/home"]);
  }

  signstud(studentdetails) {
    console.log("hello");
    this.service.signstudent(studentdetails).then(response => {
      console.log(response)
    }).catch(error => { console.log(error) });

  }
  message: any;
  emailmessage: any;
  validatePrn(studentPrn) {


    console.log(studentPrn);
    this.service.getStudentDetails(studentPrn).then(response => {
      if (response != null) {
        this.message = "Student aleady exist"
      }
    }).catch(error => { console.log(error) });

  }

  validateEmail(studentEmail) {
    this.service.validateEmail(studentEmail).then(response => {
      if (response != null) {
        this.emailmessage = "Email aleady exist"
      }
    }).catch(error => { console.log(error) });


  }

  restmesage() {
    this.message = "";
  }
  restemail() {
    this.emailmessage = "";
  }






}