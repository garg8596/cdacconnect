import { Component, OnInit } from '@angular/core';
import { StudentsService } from '../students.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-notices',
  templateUrl: './notices.component.html',
  styleUrls: ['./notices.component.css']
})

export class NoticesComponent implements OnInit {
  studentnotices: any;
  constructor(private _studentService: StudentsService, private router: Router) {

    this.getDisplay();
  }
  status = false;
  public notices: any = [];

  ngOnInit() {
    //   this._studentService.getNotices().subscribe(data => this.notices = data);
  }

  /*  getDisplay()
    {
      return this.notices;
    }
  }*/

  getDisplay() {

    return this._studentService.getNotices().subscribe((data) => this.notices = data);

  }

  onclick() {
    this.status = true;
  }

  StudentNotices: any;
  getViewDetails(noticeId) {

    this._studentService.getViewdetails(noticeId).then(response => {
      this.StudentNotices = response
      console.log(response)
    }).catch(error => { console.log(error) });

  }

  viewNotice(item) {
    this.router.navigate(["/viewnotice", item.noticeId]);
  }

}
