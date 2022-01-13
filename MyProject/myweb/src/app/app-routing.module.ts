import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { LoginComponent } from "./login/login.component";
import { RegisterComponent } from "./register/register.component";
import { ForgotpwdComponent } from "./forgotpwd/forgotpwd.component";
import { ResetpwdComponent } from "./resetpwd/resetpwd.component";
import { NoticesComponent } from "./notices/notices.component";
import { TimetableComponent } from "./timetable/timetable.component";
import { SotmComponent } from "./sotm/sotm.component";
import { ComplaintsComponent } from "./complaints/complaints.component";
import { ResultsComponent } from "./results/results.component";
import { AboutComponent } from "./about/about.component";
import { HomeComponent } from "./home/home.component";
import { CcNoticesComponent } from "./cc-notices/cc-notices.component";
import { CcSotmComponent } from "./cc-sotm/cc-sotm.component";
import { CcComplaintsComponent } from "./cc-complaints/cc-complaints.component";
import { ViewsotmComponent } from "./viewsotm/viewsotm.component";
import { ViewnoticeComponent } from './viewnotice/viewnotice.component';
import { ViewcomplaintComponent } from './viewcomplaint/viewcomplaint.component';
import { EditnoticeComponent } from './editnotice/editnotice.component';
import { EditsotmComponent } from './editsotm/editsotm.component';
import { ReplycomplaintComponent } from './replycomplaint/replycomplaint.component';
import { CcResultsComponent } from './cc-results/cc-results.component';
import { CcExternalresultComponent } from './cc-externalresult/cc-externalresult.component';
import { ProfileComponent } from './profile/profile.component';
import { CcStudentdataComponent } from './cc-studentdata/cc-studentdata.component';

const routes: Routes = [
  { path: "", component: HomeComponent },
  { path: "login", component: LoginComponent },
  { path: "register", component: RegisterComponent },
  { path: "forgotpwd", component: ForgotpwdComponent },
  { path: "resetpwd", component: ResetpwdComponent },
  { path: "notices", component: NoticesComponent },
  { path: "profile", component: ProfileComponent },
  { path: "sotm", component: SotmComponent },
  { path: "complaints", component: ComplaintsComponent },
  { path: "results", component: ResultsComponent },
  { path: "about", component: AboutComponent },
  { path: "home", component: HomeComponent },
  { path: "viewsotm/:id", component: ViewsotmComponent },
  { path: "viewnotice/:id", component: ViewnoticeComponent },
  { path: "viewcomplaint/:id", component: ViewcomplaintComponent },
  { path: "forgotpwd/:id", component: ForgotpwdComponent },
  { path: "resetpwd/:prn/:id", component: ResetpwdComponent },

  // course-coordinator components-----------------------------------------

  { path: "cc-notices", component: CcNoticesComponent },
  { path: "cc-sotm", component: CcSotmComponent },
  { path: "cc-complaints", component: CcComplaintsComponent },
  { path: "cc-studentdata", component: CcStudentdataComponent },
  { path: "cc-results", component: CcResultsComponent },
  { path: 'cc-externalresult', component: CcExternalresultComponent },
  { path: "editnotice/:id", component: EditnoticeComponent },
  { path: "editsotm/:id", component: EditsotmComponent },
  { path: "replycomplaint/:id", component: ReplycomplaintComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
