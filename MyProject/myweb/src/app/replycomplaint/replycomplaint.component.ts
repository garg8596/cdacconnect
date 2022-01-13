import { Component, OnInit } from '@angular/core';
import { StudentsService } from '../students.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-replycomplaint',
  templateUrl: './replycomplaint.component.html',
  styleUrls: ['./replycomplaint.component.css']
})
export class ReplycomplaintComponent implements OnInit {

  constructor(private _studentService: StudentsService, private route: ActivatedRoute, private router: Router) { }

  public id: string;

  ngOnInit() {

    this.route.paramMap.subscribe(
      params => {
        this.id = params.get('id');

      });

    this._studentService.getComplaintdetails(parseInt(this.id)).then(response => {
      this.studentcomplaints = response,
        console.log(response)
    }).catch(error => { console.log(error) });

  }

  studentcomplaints: any;

  gotoBack() {

    this.router.navigate(["/cc-complaints"]).then(() => {
      window.location.reload();
    });

  }

  submitData(rplycomplaints) {

    //getComplaintdetails(complaintId)
    // rplycomplaints.id = parseInt(this.id);
    rplycomplaints.coordinatorComplaintSubjectName = this.studentcomplaints.complaintSubjectName;
    rplycomplaints.coordinatorcomplaintDescription = this.studentcomplaints.complaintDescription;

    rplycomplaints.studComplaint = this.studentcomplaints;
    console.log(rplycomplaints);
    this._studentService.setReplyComplaint(rplycomplaints).then(response => {
      console.log(response)
    }).catch(error => { console.log(error) });

    this._studentService.updateStudentComplaint(parseInt(this.id)).then(response => {
      console.log(response)
    }).catch(error => { console.log(error) });

    this.router.navigate(["/cc-complaints"]).then(() => {
      window.location.reload();
    });

  }

}
