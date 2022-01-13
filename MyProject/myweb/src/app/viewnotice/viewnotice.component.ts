import { Component, OnInit } from '@angular/core';
import { StudentsService } from '../students.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Location } from '@angular/common';

@Component({
  selector: 'app-viewnotice',
  templateUrl: './viewnotice.component.html',
  styleUrls: ['./viewnotice.component.css']
})
export class ViewnoticeComponent implements OnInit {

  constructor(private _studentService: StudentsService, private route: ActivatedRoute, private router: Router, private location: Location) { }

  public sotm = [];

  public com_notices: any;

  public id: string;

  loggedCoordinator = localStorage.getItem("loggedInCoordinator");


  ngOnInit() {

    this.route.paramMap.subscribe(
      params => {
        this.id = params.get('id');
      }
    );

    this._studentService.getViewdetails(parseInt(this.id)).then(response => {
      this.com_notices = response
    }).catch(error => { console.log(error) });

  }

  gotoBack() {
    this.location.back();
    // if (this.loggedCoordinator == null) {
    //   console.log("abcd");
    //   this.router.navigate(["/notices"]);
    // }
    // else {
    //   this.router.navigate(["/cc-notices"]);
    // }

  }

}