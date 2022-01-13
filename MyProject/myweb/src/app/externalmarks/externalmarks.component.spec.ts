import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExternalmarksComponent } from './externalmarks.component';

describe('ExternalmarksComponent', () => {
  let component: ExternalmarksComponent;
  let fixture: ComponentFixture<ExternalmarksComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExternalmarksComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExternalmarksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
