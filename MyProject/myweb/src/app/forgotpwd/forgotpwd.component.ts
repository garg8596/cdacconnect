import { Component, OnInit } from '@angular/core';
import { user } from '../login/user';
import { StudentsService } from '../students.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-forgotpwd',
  templateUrl: './forgotpwd.component.html',
  styleUrls: ['./forgotpwd.component.css']
})
export class ForgotpwdComponent implements OnInit {

  constructor(private service: StudentsService, private router: Router, private _studentService: StudentsService, private route: ActivatedRoute) { }

  forgotModel = new user('', '');

  public id: string;

  ngOnInit() {
    this.route.paramMap.subscribe(
      params => {
        this.id = params.get('id');
      }
    );




  }
  message: any;
  foregetpasswordStud(value) {
    console.log(value);
    this.service.ForgotPass(value).then(response => {
      console.log(response);
      this.router.navigate(["/resetpwd", value.studentPrn, this.id]);

    }).catch(error => { console.log(error), this.message = error.error });



  }

  foregetpasswordcoord(item) {
    console.log(item.courseId);
    this.service.ForgotPasscordinator(item).then(response => {
      console.log(response);
      this.router.navigate(["/resetpwd", item.courseId, this.id]);
    }).catch(error => { console.log(error), this.message = error.error });

    // this.router.navigate(["/resetpwd", item.studentPrn]);
  }

}
