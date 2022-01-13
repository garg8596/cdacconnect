import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CcSotmComponent } from './cc-sotm.component';

describe('CcSotmComponent', () => {
  let component: CcSotmComponent;
  let fixture: ComponentFixture<CcSotmComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CcSotmComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CcSotmComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
