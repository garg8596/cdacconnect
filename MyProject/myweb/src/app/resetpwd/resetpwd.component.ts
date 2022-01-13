import { Component, OnInit } from '@angular/core';
import { pass } from './resetpwd';
import { Router, ActivatedRoute } from '@angular/router';
import { StudentsService } from '../students.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-resetpwd',
  templateUrl: './resetpwd.component.html',
  styleUrls: ['./resetpwd.component.css']
})
export class ResetpwdComponent implements OnInit {

  constructor(private service: StudentsService, private router: Router, private _studentService: StudentsService, private route: ActivatedRoute, private location: Location) { }

  resetModel = new pass('', '');

  public id: string;
  public prn;
  public courseId;
  studentdetails: any;
  ngOnInit() {
    this.route.paramMap.subscribe(
      params => {
        this.id = params.get('id');
        this.prn = params.get('prn');
        this.courseId = params.get('courseId');
      }
    );

    if (this.id == 'student') {
      this.service.getStudentDetails(parseInt(this.prn)).then(response => {

        this.studentdetails = response
      }).catch(error => { console.log(error) });
    }
    if (this.id == 'coordinator') {
      console.log(this.courseId);
      this.service.getCoordinatorDetails(2019068001).then(response => {
        console.log(response)
        this.coursedetails = response
      }).catch(error => { console.log(error) });

    }

  }
  coursedetails: any;

  Submit(value) {


    if (this.id === 'student') {
      if (value.password === value.cpass) {
        this.studentdetails.password = value.password;
        if (confirm("Are you Sure")) {
          this.service.updateStudentDet(this.studentdetails).then(response => {

            console.log(response)
          }).catch(error => { console.log(error) });
          console.log(value);
          this.router.navigate(["/login"]);
          console.log(this.studentdetails);
        }
      }
      else {
        alert("Password are not match");
      }
    }
    else {

      console.log("coordinator");
      if (value.password === value.cpass) {
        this.coursedetails.coordinatorPassword = value.password;
        if (confirm("Are you Sure")) {
          this.service.UpdateCoordinatorPass(this.coursedetails).then(response => {

            console.log(response)
          }).catch(error => { console.log(error) });
          console.log(value);
          this.router.navigate(["/login"]);

          console.log(this.coursedetails);
        }
      }
      else {
        alert("Password are not match");
      }


    }
  }



  gotoBack() {
    this.location.back();
  }



}
