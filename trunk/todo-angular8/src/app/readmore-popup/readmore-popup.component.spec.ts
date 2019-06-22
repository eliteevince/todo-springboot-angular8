import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReadmorePopupComponent } from './readmore-popup.component';

describe('ReadmorePopupComponent', () => {
  let component: ReadmorePopupComponent;
  let fixture: ComponentFixture<ReadmorePopupComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReadmorePopupComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReadmorePopupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
