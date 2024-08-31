import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CommitScientifiqueDashboardComponent } from './commit-scientifique-dashboard.component';

describe('CommitScientifiqueDashboardComponent', () => {
  let component: CommitScientifiqueDashboardComponent;
  let fixture: ComponentFixture<CommitScientifiqueDashboardComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CommitScientifiqueDashboardComponent]
    });
    fixture = TestBed.createComponent(CommitScientifiqueDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
