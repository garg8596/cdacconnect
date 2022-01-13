import { Component, OnInit } from '@angular/core';
import { StudentsService } from '../students.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Location } from '@angular/common';
@Component({
  selector: 'app-editsotm',
  templateUrl: './editsotm.component.html',
  styleUrls: ['./editsotm.component.css']
})
export class EditsotmComponent implements OnInit {
  MonthName = ["January", "Febuary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];

  constructor(private _studentService: StudentsService, private route: ActivatedRoute, private router: Router, private location: Location) { }

  public id: string;

  ngOnInit() {
    this.route.paramMap.subscribe(
      params => {
        this.id = params.get('id');
      }
    );
    this._studentService.getStomData(parseInt(this.id)).then(response => {
      console.log(response), this.stomdetails = response
    }).catch(error => { console.log(error) });
  }

  gotoBack() {
    this.location.back();
  }

  stomdetails: any;
  // getData() {

  //   this._studentService.getStomData(parseInt(this.id)).then(response => {
  //     console.log(response), this.stomdetails = response
  //   }).catch(error => { console.log(error) });

  // }
  flag: any;
  monthDetails = ["Januray", "December", "November", "October"];
  coordinatordetails: any;
  submitSotm(stomdata) {


    for (let i = 0; i < this.monthDetails.length; i++) {
      if (stomdata.monthName == this.monthDetails[i] && this.stomdetails.monthName != this.monthDetails[i]) {
        this.flag = true;
      }

    }

    if (this.flag == true) {
      alert("Sotm already  exist for this month ");

    }
    else {
      this.monthDetails.push(stomdata.monthName);
      console.log(stomdata);
      stomdata.stomId = parseInt(this.id);

      stomdata.selectedMonthCourse = JSON.parse(localStorage.getItem("mydata"));
      this._studentService.updateccSotm(stomdata).then(response => {
        console.log(response), this.stomdetails = response
      }).catch(error => { console.log(error) });

      this.router.navigate(["/cc-sotm"]).then(() => {
        window.location.reload();
      });
    }
  }

}
