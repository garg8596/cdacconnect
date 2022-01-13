import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SotmComponent } from './sotm.component';

describe('SotmComponent', () => {
  let component: SotmComponent;
  let fixture: ComponentFixture<SotmComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SotmComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SotmComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
