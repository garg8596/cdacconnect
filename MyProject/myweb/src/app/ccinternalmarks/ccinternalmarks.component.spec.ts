import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CcinternalmarksComponent } from './ccinternalmarks.component';

describe('CcinternalmarksComponent', () => {
  let component: CcinternalmarksComponent;
  let fixture: ComponentFixture<CcinternalmarksComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CcinternalmarksComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CcinternalmarksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
