import { Component, OnInit } from "@angular/core";
import { StudentsService } from "../students.service";
import { Router } from "@angular/router";

@Component({
  selector: "app-home",
  templateUrl: "./home.component.html",
  styleUrls: ["./home.component.css"]
})
export class HomeComponent implements OnInit {
  constructor(private _studentService: StudentsService, private router: Router) {
    this.getDisplay();
  }

  public notices: any = [];

  ngOnInit() {
    // this._studentService.getNotices().subscribe(data => this.notices = data);
  }

  getDisplay() {
    this._studentService.getNotices().subscribe(data => (this.notices = data));
  }

  viewNotice(item) {
    this.router.navigate(["/viewnotice", item.noticeId]);
  }

}
