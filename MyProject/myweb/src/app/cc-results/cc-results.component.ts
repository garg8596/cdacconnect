import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { StudentsService } from '../students.service';
import { Router } from '@angular/router';
import * as $ from 'jquery';

@Component({
  selector: 'app-cc-results',
  templateUrl: './cc-results.component.html',
  styleUrls: ['./cc-results.component.css']
})
export class CcResultsComponent implements OnInit {

  // Subject = [{ "SubjectCode": "001", "SubjectName": "CPP" }, { "SubjectCode": "002", "SubjectName": "Java" }, { "SubjectCode": "003", "SubjectName": "MS.net" }, { "SubjectCode": "004", "SubjectName": "AWP" }];

  studentdetails: any = [];
  objects: any;
  uniquedata: any = [];
  processdata: any;
  AllStudentData: any = [];
  constructor(private fb: FormBuilder, private _studentService: StudentsService, private router: Router) { }

  InternalResultsForm: FormGroup;

  AllStudentDatas = [
    {
      'prn': '190840120216'
    },
    {
      'prn': '190840120170'
    },
    {
      'prn': '190840120045'
    },
    {
      'prn': '190840120145'
    },
  ]

  createform() {
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
      labInternal: ['', [Validators.required, Validators.min(0), Validators.max(20)]],
      labExam: ['', [Validators.required, Validators.min(0), Validators.max(40)]]
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

  interdat: any;
  inputsubjectname: any;
  SaveData() {

    console.log(this.InternalResultsForm.value);
    console.log(this.InternalResultsForm.value.StudentDetails)
    console.log(this.InternalResultsForm.value.StudentDetails[0])
    this.InternalResultsForm.value.StudentDetails[0].subjectName = "DS";
    console.log(this.InternalResultsForm.value.StudentDetails[0]);
    this.inputsubjectname = this.InternalResultsForm.value.SubjectName;
    delete this.InternalResultsForm.value.StudentDetails[0]['studentPrn'];
    for (let i = 0; i < this.InternalResultsForm.value.StudentDetails.length; i++) {
      this.InternalResultsForm.value.StudentDetails[i].subjectName = this.inputsubjectname;
      this.InternalResultsForm.value.StudentDetails[i].studentmarks = this.studentdetails[i];
      this.interdat = (this.InternalResultsForm.value.StudentDetails[i]);

      console.log(this.interdat);

      this._studentService.insertdata(this.interdat).then(response => {

      }).catch(error => { console.log(error) });
      this.router.navigate(["/cc-results"]).then(() => {
        window.location.reload();
      });
    }

    // let processeddata = this.InternalResultsForm.value.StudentDetails.map(dat => ({ LabInternal: dat.LabInternal, LabExam: dat.LabExam }));
    // let uniqueeddata = Array.from(new Set(processeddata.map((x) => JSON.stringify(x)))).map((y) => JSON.parse(y.toString()));
    // console.log(uniqueeddata);


  }


  // getdisplay() {



  //   // this.createform();

  //   // JSON.stringify(this.AllStudentData);




  // }
}