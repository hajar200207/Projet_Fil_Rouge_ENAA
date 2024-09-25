import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LocauxManagementComponent } from './locaux-management.component';

describe('LocauxManagementComponent', () => {
  let component: LocauxManagementComponent;
  let fixture: ComponentFixture<LocauxManagementComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [LocauxManagementComponent]
    });
    fixture = TestBed.createComponent(LocauxManagementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
