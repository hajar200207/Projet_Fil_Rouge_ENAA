import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterCommitOrganisationComponent } from './register-commit-organisation.component';

describe('RegisterCommitOrganisationComponent', () => {
  let component: RegisterCommitOrganisationComponent;
  let fixture: ComponentFixture<RegisterCommitOrganisationComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RegisterCommitOrganisationComponent]
    });
    fixture = TestBed.createComponent(RegisterCommitOrganisationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
