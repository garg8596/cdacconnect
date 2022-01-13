import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CcNoticesComponent } from './cc-notices.component';

describe('CcNoticesComponent', () => {
  let component: CcNoticesComponent;
  let fixture: ComponentFixture<CcNoticesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CcNoticesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CcNoticesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
