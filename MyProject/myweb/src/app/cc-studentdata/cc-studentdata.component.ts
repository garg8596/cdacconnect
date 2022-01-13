import { Component, OnInit } from '@angular/core';
import { StudentsService } from '../students.service';

@Component({
  selector: 'app-cc-studentdata',
  templateUrl: './cc-studentdata.component.html',
  styleUrls: ['./cc-studentdata.component.css']
})
export class CcStudentdataComponent implements OnInit {

  constructor(private _studentService: StudentsService) { }

  studentDetails: any = [];
  ngOnInit() {


    this._studentService.getStudents().subscribe(data => this.studentDetails = data);
  }


  verifyStudent(item) {

    console.log(item.studentPrn);
    this._studentService.updateStudentDetails(item.studentPrn).then(response => {
      console.log(response)
    }).catch(error => { console.log(error) });

    window.location.reload();

  }



}
