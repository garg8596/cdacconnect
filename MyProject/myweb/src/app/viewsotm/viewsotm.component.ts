import { Component, OnInit } from '@angular/core';
import { StudentsService } from '../students.service';
import { ActivatedRoute, Router, ParamMap } from '@angular/router';
import { Location } from '@angular/common';

@Component({
  selector: 'app-viewsotm',
  templateUrl: './viewsotm.component.html',
  styleUrls: ['./viewsotm.component.css']
})

export class ViewsotmComponent implements OnInit {

  constructor(private _studentService: StudentsService, private route: ActivatedRoute, private router: Router, private location: Location) { }

  public sotm = [];

  public com_sotm = [];

  public id: string;

  loggedCoordinator = localStorage.getItem("loggedInCoordinator");

  ngOnInit() {

    this._studentService.getSotm().subscribe(data => this.sotm = data);

    this.route.paramMap.subscribe(
      params => {
        this.id = params.get('id');
      }
    );

    this._studentService.getStomData(parseInt(this.id)).then(response => {
      this.studentStom = response,
        console.log(response)
    }).catch(error => { console.log(error) });

  }

  studentStom: any;

  gotoBack() {
    this.location.back();
    // if (this.loggedCoordinator == null) {
    //   this.router.navigate(["/sotm"]);
    // }
    // else {
    //   this.router.navigate(["/cc-sotm"]);
    // }

  }

  getDisplay() {
    return this.sotm;
  }

}