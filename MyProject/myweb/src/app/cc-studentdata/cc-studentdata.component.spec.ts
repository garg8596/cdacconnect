import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CcStudentdataComponent } from './cc-studentdata.component';

describe('CcStudentdataComponent', () => {
  let component: CcStudentdataComponent;
  let fixture: ComponentFixture<CcStudentdataComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CcStudentdataComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CcStudentdataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
