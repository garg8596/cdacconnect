import { Component, OnInit } from '@angular/core';
import { StudentsService } from '../students.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Location } from '@angular/common';

@Component({
  selector: 'app-editnotice',
  templateUrl: './editnotice.component.html',
  styleUrls: ['./editnotice.component.css']
})
export class EditnoticeComponent implements OnInit {

  constructor(private _studentService: StudentsService, private route: ActivatedRoute, private router: Router, private location: Location) { }

  com_notices: any;
  public id: string;

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
  }

  submitData(updateNotice) {

    updateNotice.noticeId = parseInt(this.id);
    updateNotice.publishedBy = this.com_notices.publishedBy;
    updateNotice.selectedCourseNotice = JSON.parse(localStorage.getItem("mydata"));
    this._studentService.updateNotices(updateNotice).then(response => {
      this.com_notices = response

    }).catch(error => { console.log(error) });


    this.router.navigate(["/cc-notices"]).then(() => {
      window.location.reload();
    });

  }
}
