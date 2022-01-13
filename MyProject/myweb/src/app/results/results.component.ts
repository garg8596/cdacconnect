import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { StudentsService } from '../students.service';
import { InternalMark } from './InternalMarks';

@Component({
  selector: 'app-results',
  templateUrl: './results.component.html',
  styleUrls: ['./results.component.css']
})
export class ResultsComponent implements OnInit {

  constructor(private router: Router, private _studentService: StudentsService) { }

  loggedUser = localStorage.getItem("loggedInUser");


  studentdetail: any;
  internalmark: any = [];
  externalmark: any = [];
  ngOnInit() {
    this._studentService.getStudentDetails(parseInt(this.loggedUser)).then(response => {
      this.studentdetail = response,
        console.log(response)
    }).catch(error => { console.log(error) });

  }

  logStatus = true;
  gotoLogin() {
    if (this.logStatus == true) {
      this.logStatus = false;
      alert("Please Login First!!!");
      this.router.navigate(['/login']);
    }
  }

  getData() {

    console.log(this.studentdetail);

    this._studentService.getinternalMark(this.studentdetail).subscribe((data) => { this.internalmark = data, console.log(data) });
    this._studentService.getexternalMark(this.studentdetail).subscribe((data) => { this.externalmark = data, console.log(data) });

    delete this.internalmark['studentStatus'];
    console.log("hello")
    console.log(this.internalmark);

  }

  totaldata: any = [];
  getDisplay() {
    for (let i = 0; i < this.internalmark.length; i++) {

      for (let j = 0; j < this.externalmark.length; j++) {
        if (this.internalmark[i].subjectName.toLowerCase() === this.externalmark[j].subjectName.toLowerCase()) {
          this.internalmark[i].theoryMarks = this.externalmark[j].theoryMarks;
          console.log(this.externalmark[j].subjectName.toLowerCase() + "hello" + this.internalmark[i].theoryMarks);

        }

      }
    }
    for (let i = 0; i < this.internalmark.length; i++) {
      if (this.internalmark[i].theoryMarks >= 0 && this.internalmark[i].theoryMarks < 41) {

      }
      else {
        this.internalmark[i].theoryMarks = "--";
      }

      if (this.internalmark[i].labInternal >= 0 && this.internalmark[i].labInternal < 21) {

      }
      else {
        this.internalmark[i].labInternal = "--";
      }
      if (this.internalmark[i].labExam >= 0 && this.internalmark[i].labExam < 41) {

      }
      else {
        this.internalmark[i].labExam = "--";
      }
    }

    this.totaldata = this.internalmark;
    console.log(this.internalmark);
    console.log(this.totaldata);
  }


}
