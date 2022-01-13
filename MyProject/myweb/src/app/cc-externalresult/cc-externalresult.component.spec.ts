import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CcExternalresultComponent } from './cc-externalresult.component';

describe('CcExternalresultComponent', () => {
  let component: CcExternalresultComponent;
  let fixture: ComponentFixture<CcExternalresultComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CcExternalresultComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CcExternalresultComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
