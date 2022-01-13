import { Component, OnInit } from '@angular/core';
import * as $ from 'jquery';
import { StudentsService } from '../students.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-complaints',
  templateUrl: './complaints.component.html',
  styleUrls: ['./complaints.component.css']
})

export class ComplaintsComponent implements OnInit {

  constructor(private _studentService: StudentsService, private router: Router) {
    this.getDisplay();
  }

  loggedUser = localStorage.getItem("loggedInUser");

  studetprn = parseInt(localStorage.getItem("loggedInUser"));

  //cModel = new Complaints('','');

  public allcomplaints: any = [];
  public actComplaints: any = [];
  public oldComplaints: any = [];

  ngOnInit() {
    // this._studentService.getComplaints().subscribe(data => this.complaints = data);
    $(document).ready(function () {
      $("#getcform").click(function () {
        $('form').removeClass('cform');
      })
      $("#closecform").click(function () {
        $('form').addClass('cform');
        window.location.reload();
      })
    })

  }

  logStatus = true;
  gotoLogin() {
    if (this.logStatus == true) {
      this.logStatus = false;
      alert("Please Login First!!!");
      this.router.navigate(['/login']);
    }
  }

  getDisplay() {
    this._studentService.getComplaints(this.studetprn).subscribe((data) => this.allcomplaints = data);
    this.actComplaints = this.allcomplaints;
  }

  status = true;
  getData() {
    if (this.status == true) {
      console.log("abcd");

      this.allcomplaints.forEach(Complaints => {
        if (Complaints.complaintStatus == 'Active') {
          console.log("Active");
          this.actComplaints.push(Complaints);
        }
        if (Complaints.complaintStatus == 'Unactive')
          this.oldComplaints.push(Complaints);
      });
    }
    this.status = false;
  }

  StudentComplaints: any;
  getComplaintdetails(complaintId) {
    this._studentService.getComplaintdetails(complaintId).then(response => {
      this.StudentComplaints = response
      console.log(response)
    }).catch(error => { console.log(error) });
  }

  getNewComplaint(studentnewcomp) {
    console.log(studentnewcomp);
    studentnewcomp.studentPrn = parseInt(localStorage.getItem("loggedInUser"));
    this._studentService.getNewComplaintdetails(studentnewcomp).then(response => {
      console.log(response)
    }).catch(error => { console.log(error) });
    window.location.reload();
  }

  viewComplaint(item) {
    this.router.navigate(["/viewcomplaint", item.studentcomplaintId]);
  }

  // activeStatus = true;
  // getActiveCom() {
  //   if (this.activeStatus == true) {
  //     this.allcomplaints.forEach(Complaints => {
  //       if (Complaints.complaintStatus == 'Active') {
  //         console.log("Active");
  //         this.actComplaints.push(Complaints);
  //       }
  //     });
  //     this.activeStatus = false;
  //     return this.actComplaints;
  //   }
  // }

  // closedStatus = true;
  // getClosedCom() {
  //   if (this.closedStatus == true) {
  //     this.allcomplaints.forEach(Complaints => {
  //       if (Complaints.complaintStatus == 'Unactive') {
  //         console.log("Unactive");
  //         this.oldComplaints.push(Complaints);
  //       }
  //     });
  //     this.closedStatus = false;
  //     return this.oldComplaints;
  //   }

  // }

}