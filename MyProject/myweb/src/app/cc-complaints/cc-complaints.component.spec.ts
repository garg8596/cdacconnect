import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CcComplaintsComponent } from './cc-complaints.component';

describe('CcComplaintsComponent', () => {
  let component: CcComplaintsComponent;
  let fixture: ComponentFixture<CcComplaintsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CcComplaintsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CcComplaintsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
