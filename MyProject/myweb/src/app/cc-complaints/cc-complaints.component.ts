import { Component, OnInit } from '@angular/core';
import { StudentsService } from '../students.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cc-complaints',
  templateUrl: './cc-complaints.component.html',
  styleUrls: ['./cc-complaints.component.css']
})
export class CcComplaintsComponent implements OnInit {

  loggedCoordinator = localStorage.getItem("loggedInCoordinator");

  studetprn = 190145;
  //cModel = new Complaints('','');

  public allcomplaints: any = [];
  public actComplaints: any = [];
  public oldComplaints: any = [];

  constructor(private _studentService: StudentsService, private router: Router) {
    this.getDisplay();
  }

  ngOnInit() {
  }

  getDisplay() {
    console.log("service");
    this._studentService.getALLComplaints().subscribe((data) => this.allcomplaints = data);
    this.actComplaints = this.allcomplaints;

  }

  logStatus = true;
  gotoLogin() {
    if (this.logStatus == true) {
      this.logStatus = false;
      alert("Please Login First!!!");
      this.router.navigate(['/login']);
    }
  }

  status = true;
  getData() {
    console.log("hello");
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

  viewComplaint(item) {
    this.router.navigate(["/viewcomplaint", item.studentcomplaintId]);
  }

  replyComplaint(item) {
    this.router.navigate(["/replycomplaint", item.studentcomplaintId]);
  }

}
