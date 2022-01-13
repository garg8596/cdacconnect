import { Component, OnInit } from '@angular/core';
import { StudentsService } from '../students.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import * as $ from 'jquery';

@Component({
  selector: 'app-cc-externalresult',
  templateUrl: './cc-externalresult.component.html',
  styleUrls: ['./cc-externalresult.component.css']
})
export class CcExternalresultComponent implements OnInit {

  constructor(private _studentService: StudentsService, private fb: FormBuilder, private router: Router) {

  }

  studentdetails: any = [];
  objects: any;
  uniquedata: any = [];
  processdata: any;
  AllStudentData: any = [];
  InternalResultsForm: FormGroup;
  createform() {
    console.log("sudent!!!!!!!!!!!!!!");

    this._studentService.getStudents().subscribe((data) => this.studentdetails = data);

    this.processdata = this.studentdetails.map(dat => ({ studentPrn: dat.studentPrn }));

    this.AllStudentData = Array.from(new Set(this.processdata.map((x) => JSON.stringify(x)))).map((y) => JSON.parse((y.toString())));
    console.log(this.uniquedata);
    let arr = [];
    for (let i = 0; i < this.AllStudentData.length; i++) {
      arr.push(this.BuildFormDynamic(this.AllStudentData[i]))
    }
    this.InternalResultsForm = this.fb.group({
      SubjectName: ['', Validators.required],
      StudentDetails: this.fb.array(arr)
    })
  }


  BuildFormDynamic(StudentDatas): FormGroup {
    return this.fb.group({
      studentPrn: [StudentDatas.studentPrn],
      theoryMarks: ['', [Validators.required, Validators.min(0), Validators.max(40)]]
    })
  }


  ngOnInit() {
    $(document).ready(function () {
      $("#getcform").click(function () {
        $('form').removeClass('cform');
      })
      $("#closecform").click(function () {
        $('form').addClass('cform');
      })
    })
    this.createform();
  }

  inputsubjectname: any;
  interdat: any;
  SaveData() {

    console.log(this.InternalResultsForm.value);
    console.log(this.InternalResultsForm.value.StudentDetails)
    console.log(this.InternalResultsForm.value.StudentDetails[0])
    //this.InternalResultsForm.value.StudentDetails[0].subjectName = "DS";
    console.log(this.InternalResultsForm.value.StudentDetails[0]);
    this.inputsubjectname = this.InternalResultsForm.value.SubjectName;
    delete this.InternalResultsForm.value.StudentDetails[0]['studentPrn'];
    for (let i = 0; i < this.InternalResultsForm.value.StudentDetails.length; i++) {
      this.InternalResultsForm.value.StudentDetails[i].subjectName = this.inputsubjectname;
      this.InternalResultsForm.value.StudentDetails[i].studentexternalmarks = this.studentdetails[i];
      this.interdat = (this.InternalResultsForm.value.StudentDetails[i]);

      console.log(this.interdat);

      this._studentService.insertexternaldata(this.interdat).then(response => {

      }).catch(error => { console.log(error) });
      this.router.navigate(["/cc-results"]).then(() => {
        window.location.reload();
      });
    }
  }
}