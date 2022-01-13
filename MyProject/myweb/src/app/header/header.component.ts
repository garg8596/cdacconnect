import { Component, OnInit } from '@angular/core';
import { StudentsService } from '../students.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  loggedInCoordinator: string;
  loggedInUser: string;
  ccordinatorname: any;

  constructor(private service: StudentsService, private router: Router) {

  }

  ngOnInit() {
    this.loggedInCoordinator = localStorage.getItem("loggedInCoordinator");
    console.log(this.loggedInCoordinator);

    this.loggedInUser = localStorage.getItem("loggedInUser");
    console.log(this.loggedInUser);
  }

  message: any;
  ccdetails: any;
  sdetails: any;

  statuserror = true;
  getDisplay() {
    parseInt(localStorage.getItem("loggedInCoordinator"));
    console.log("getdisplay");
    if (this.statuserror == true) {
      console.log(parseInt(localStorage.getItem("loggedInCoordinator")));
      console.log("getdisplay");
      this.service
        .getCoordinatorDetails(parseInt(localStorage.getItem("loggedInCoordinator")))
        .then(response => {
          this.ccdetails = response;
          localStorage.setItem("mydata", JSON.stringify(response));
        })
        .catch(error => {
          this.message = "could not create Account";
        });
      console.log("heloo");
    }
    this.statuserror = false;
  }

  getStudDisplay() {
    parseInt(localStorage.getItem("loggedInUser"));
    console.log("getStuddisplay");
    if (this.statuserror == true) {
      console.log(parseInt(localStorage.getItem("loggedInUser")));
      console.log("getStuddisplay");
      this.service
        .getStudentDetails(parseInt(localStorage.getItem("loggedInUser")))
        .then(response => {
          this.sdetails = response;
          localStorage.setItem("smydata", JSON.stringify(response));
        })
        .catch(error => {
          this.message = "could not create Account";
        });
      console.log("heloo");
    }
    this.statuserror = false;
  }

  logout() {
    console.log("heloo");
    localStorage.removeItem("loggedInCoordinator");
    localStorage.removeItem("loggedInUser");
    localStorage.removeItem("mydata");
    localStorage.removeItem("smydata");
    this.router.navigate(["/home"]).then(() => {
      window.location.reload();
    });
  }

}