import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LeftSidebarComponent } from './left-sidebar/left-sidebar.component';
import { HeaderComponent } from './header/header.component';
import { AboutComponent } from './about/about.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { NoticesComponent } from './notices/notices.component';
import { SotmComponent } from './sotm/sotm.component';
import { ComplaintsComponent } from './complaints/complaints.component';
import { ResultsComponent } from './results/results.component';
import { ForgotpwdComponent } from './forgotpwd/forgotpwd.component';
import { ResetpwdComponent } from './resetpwd/resetpwd.component';
import { HomeComponent } from './home/home.component';
import { HttpClientModule } from '@angular/common/http';
import { ViewsotmComponent } from './viewsotm/viewsotm.component';
import { CcNoticesComponent } from './cc-notices/cc-notices.component';
import { CcSotmComponent } from './cc-sotm/cc-sotm.component';
import { CcComplaintsComponent } from './cc-complaints/cc-complaints.component';
import { CcinternalmarksComponent } from './ccinternalmarks/ccinternalmarks.component';
import { ViewnoticeComponent } from './viewnotice/viewnotice.component';
import { ViewcomplaintComponent } from './viewcomplaint/viewcomplaint.component';
import { EditnoticeComponent } from './editnotice/editnotice.component';
import { EditsotmComponent } from './editsotm/editsotm.component';
import { ReplycomplaintComponent } from './replycomplaint/replycomplaint.component';
import { ProfileComponent } from './profile/profile.component';
import { CcResultsComponent } from './cc-results/cc-results.component';
import { CcExternalresultComponent } from './cc-externalresult/cc-externalresult.component';
import { CcStudentdataComponent } from './cc-studentdata/cc-studentdata.component';

@NgModule({
  declarations: [
    AppComponent,
    LeftSidebarComponent,
    HeaderComponent,
    AboutComponent,
    LoginComponent,
    RegisterComponent,
    NoticesComponent,
    SotmComponent,
    ComplaintsComponent,
    ResultsComponent,
    ForgotpwdComponent,
    ResetpwdComponent,
    HomeComponent,
    ViewsotmComponent,
    CcNoticesComponent,
    CcSotmComponent,
    CcComplaintsComponent,
    CcinternalmarksComponent,
    ViewnoticeComponent,
    ViewcomplaintComponent,
    EditnoticeComponent,
    EditsotmComponent,
    ReplycomplaintComponent,
    ProfileComponent,
    CcResultsComponent,
    CcExternalresultComponent,
    CcStudentdataComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
