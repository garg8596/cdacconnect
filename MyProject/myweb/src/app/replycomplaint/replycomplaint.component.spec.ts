import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReplycomplaintComponent } from './replycomplaint.component';

describe('ReplycomplaintComponent', () => {
  let component: ReplycomplaintComponent;
  let fixture: ComponentFixture<ReplycomplaintComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReplycomplaintComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReplycomplaintComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
