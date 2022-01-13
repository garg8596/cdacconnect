import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-left-sidebar",
  templateUrl: "./left-sidebar.component.html",
  styleUrls: ["./left-sidebar.component.css"]
})
export class LeftSidebarComponent implements OnInit {
  loggedCoordinator: any = null;
  constructor() {
    this.loggedCoordinator = localStorage.getItem("loggedInCoordinator");
  }

  ngOnInit() { }

  gotoCdac() {
    alert("You will be redirected to CDAC-Official Website.");
    window.open("https://cdac.in");
  }

  gotoFeedback() {
    alert("You will be redirected to CDAC-Feedback Website.");
    window.open("https://vm.cdac.in:8443/feedbackSystem/");
  }

}
