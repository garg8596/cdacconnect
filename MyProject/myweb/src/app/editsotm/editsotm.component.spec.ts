import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditsotmComponent } from './editsotm.component';

describe('EditsotmComponent', () => {
  let component: EditsotmComponent;
  let fixture: ComponentFixture<EditsotmComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditsotmComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditsotmComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
