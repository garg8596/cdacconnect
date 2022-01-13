import { Component, OnInit } from '@angular/core';
import { StudentsService } from '../students.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Location } from '@angular/common';

@Component({
  selector: 'app-viewcomplaint',
  templateUrl: './viewcomplaint.component.html',
  styleUrls: ['./viewcomplaint.component.css']
})
export class ViewcomplaintComponent implements OnInit {

  constructor(private _studentService: StudentsService, private route: ActivatedRoute, private router: Router, private location: Location) { }

  public id: string;

  loggedCoordinator = localStorage.getItem("loggedInCoordinator");

  ngOnInit() {

    this.route.paramMap.subscribe(
      params => {
        this.id = params.get('id');
      }
    );

    this._studentService.getComplaintdetails(parseInt(this.id)).then(response => {
      this.studentcomplaints = response,
        console.log(response)
    }).catch(error => { console.log(error) });

  }

  studentcomplaints: any;

  gotoBack() {
    this.location.back();
    // if (this.loggedCoordinator == null) {
    //   this.router.navigate(["/complaints"]);
    // }
    // else {
    //   this.router.navigate(["/cc-complaints"]);
    // }

  }

}
