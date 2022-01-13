import { Component, OnInit } from '@angular/core';
import * as $ from 'jquery';
import { StudentsService } from '../students.service';
import { CC_Notices } from './cc-notices';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cc-notices',
  templateUrl: './cc-notices.component.html',
  styleUrls: ['./cc-notices.component.css']
})
export class CcNoticesComponent implements OnInit {

  constructor(private _studentService: StudentsService, private router: Router) { }
  cModel = new CC_Notices('', '');
  coordinatorName = JSON.parse(localStorage.getItem("mydata")).coordinatorName;
  coordinatordetail = JSON.parse(localStorage.getItem("mydata"));
  public cc_notices = [];
  ngOnInit() {
    // this._studentService.getCC_Notices.subscribe(data => this.cc_notices = data);
    this._studentService.getNotices().subscribe((data) => this.cc_notices = data);
    $(document).ready(function () {
      $("#getcform").click(function () {
        $('form').removeClass('cform');
      })
      $("#closecform").click(function () {
        $('form').addClass('cform');
        window.location.reload();
      })
    })

  }

  getDisplay() {
    return this._studentService.getNotices().subscribe((data) => this.cc_notices = data);
  }

  submitData(newnotices) {
    newnotices.publishedBy = this.coordinatorName;
    newnotices.selectedCourseNotice = this.coordinatordetail;
    this._studentService.setNewNotices(newnotices).then(response => {
      console.log(response)
    }).catch(error => { console.log(error) });
    window.location.reload();
    //    this._studentService.setNewNotices(newnotices).then(response=>{
    //    console.log(response)}).catch(error=>{console.log(error)});

  }

  viewNotice(item) {
    this.router.navigate(["/viewnotice", item.noticeId]);
  }

  editNotice(item) {
    this.router.navigate(["/editnotice", item.noticeId]);
  }

  removeNotice(item) {

    console.log("remove");
    this._studentService.removeNotice(parseInt(item.noticeId)).then(response => {

      console.log(response)
    }).catch(error => { console.log(error) }).then(() => { });
    window.location.reload();

  }

}
