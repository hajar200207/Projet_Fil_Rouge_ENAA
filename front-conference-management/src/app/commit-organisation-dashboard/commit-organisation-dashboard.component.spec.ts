import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CommitOrganisationDashboardComponent } from './commit-organisation-dashboard.component';

describe('CommitOrganisationDashboardComponent', () => {
  let component: CommitOrganisationDashboardComponent;
  let fixture: ComponentFixture<CommitOrganisationDashboardComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CommitOrganisationDashboardComponent]
    });
    fixture = TestBed.createComponent(CommitOrganisationDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
