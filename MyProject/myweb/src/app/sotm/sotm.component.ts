import { Component, OnInit } from '@angular/core';
import { StudentsService } from '../students.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sotm',
  templateUrl: './sotm.component.html',
  styleUrls: ['./sotm.component.css']
})
export class SotmComponent implements OnInit {

  constructor(private _studentService: StudentsService, private router: Router) {
    this.getDisplay();
  }

  public sotm: any = [];


  ngOnInit() {
    this._studentService.getSotm().subscribe(data => this.sotm = data);
  }
  studentStom: any = [];
  getDisplay() {


    // return this._studentService.getNotices().subscribe((data) => this.sotm = data);
    for (let i = 0; i < this.sotm.length; i++) {
      this._studentService.getStudentDetails(this.sotm[i].studentprn).then(response => {
        this.studentStom[i] = response
      }).catch(error => { console.log(error) });


    }
    console.log(this.sotm);


  }

  getsubmit() {
    for (let i = 0; i < this.sotm.length; i++) {

      for (let j = 0; j < this.studentStom.length; j++) {
        if (this.sotm[i].studentprn === this.studentStom[j].studentPrn) {
          this.sotm[i].studentName = this.studentStom[i].studentName;
        }
      }

    }

    console.log(this.sotm);
  }

  viewSotm(item) {
    this.router.navigate(["/viewsotm", item.stomId]);
  }

}
