import { Component, OnInit } from '@angular/core';
import { StudentsService } from '../students.service';

@Component({
  selector: 'app-ccinternalmarks',
  templateUrl: './ccinternalmarks.component.html',
  styleUrls: ['./ccinternalmarks.component.css']
})
export class CcinternalmarksComponent implements OnInit {

  Subject=[{"SubjectCode":"001","SubjectName":"CPP"},{"SubjectCode":"002","SubjectName":"Java"},{"SubjectCode":"003","SubjectName":"MS.net"},{"SubjectCode":"004","SubjectName":"AWP"}];
  
  constructor(private _studentService:StudentsService) { }
topicHasError=false;
  ngOnInit() {
  }

  validateMonth(value)
  {
    if(''== value)
    {
      this.topicHasError=true;
    }
    else
    {
      this.topicHasError=false;
    }
  }
  submitSotm(InternalData)
 {
   
console.log(InternalData);
this._studentService.getInternalSubmit(InternalData).then(response=>{console.log(response)}).catch(error=>{console.log(error)});

  }
}
