import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterCommitScientifiqueComponent } from './register-commit-scientifique.component';

describe('RegisterCommitScientifiqueComponent', () => {
  let component: RegisterCommitScientifiqueComponent;
  let fixture: ComponentFixture<RegisterCommitScientifiqueComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RegisterCommitScientifiqueComponent]
    });
    fixture = TestBed.createComponent(RegisterCommitScientifiqueComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
