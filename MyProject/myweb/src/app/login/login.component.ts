import { Component, OnInit } from '@angular/core';
import { user } from './user';
import { StudentsService } from '../students.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  dummy: string = "dummy";
  message: string = "";
  constructor(private service: StudentsService, private router: Router) { }
  userModel = new user('', '');
  ccModel = new user('', '');
  ngOnInit() {
  }

  // authenicate(ccordcinator)
  // {
  //   console.log(ccordcinator);

  //   this.service.signin(ccordcinator).then(response=>{
  //     console.log(response)}).catch(error=>{console.log(error)});
  // }

  authenicate(ccordcinator) {
    this.service
      .signin(ccordcinator)
      .then(response => {
        localStorage.setItem("loggedInCoordinator", ccordcinator.courseId);
        this.message = "Login successful";
        this.router.navigate(["/home"]).then(() => {
          window.location.reload();
        });
      })
      .catch(error => {
        console.log(error);
        this.message = "Invalid ID or Password";
      });
    console.log(ccordcinator.cordinatorEmail);
  }

  // signstud(studentdetails)
  // {
  //   console.log("hello");
  //   this.service.signstudent(studentdetails).then(response=>{
  //     console.log(response)}).catch(error=>{console.log(error)});

  // }

  statusError: any;
  signstud(studentdetails) {
    console.log(studentdetails);
    this.service
      .signstudent(studentdetails)
      .then(response => {
        localStorage.setItem("loggedInUser", studentdetails.studentPrn);

        this.message = "Login successful";
        this.router.navigate(["/home"]).then(() => {
          window.location.reload();
        });
      })
      .catch(error => {
        this.message = error.error, console.log(error);
        // this.message = "Invalid ID or Password";
      });

  }
  dummyStud: any;
  dummyCoor: any;
  forgotPwd(item) {
    // console.log(item);
    this.router.navigate(["/forgotpwd", item]);
  }

}








