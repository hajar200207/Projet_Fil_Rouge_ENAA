import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InviteDashboardComponent } from './invite-dashboard.component';

describe('InviteDashboardComponent', () => {
  let component: InviteDashboardComponent;
  let fixture: ComponentFixture<InviteDashboardComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [InviteDashboardComponent]
    });
    fixture = TestBed.createComponent(InviteDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
