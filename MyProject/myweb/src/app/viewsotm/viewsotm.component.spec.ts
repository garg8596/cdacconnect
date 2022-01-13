import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewsotmComponent } from './viewsotm.component';

describe('ViewsotmComponent', () => {
  let component: ViewsotmComponent;
  let fixture: ComponentFixture<ViewsotmComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewsotmComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewsotmComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
