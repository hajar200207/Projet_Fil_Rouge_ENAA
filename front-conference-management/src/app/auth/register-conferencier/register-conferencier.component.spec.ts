import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterConferencierComponent } from './register-conferencier.component';

describe('RegisterConferencierComponent', () => {
  let component: RegisterConferencierComponent;
  let fixture: ComponentFixture<RegisterConferencierComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RegisterConferencierComponent]
    });
    fixture = TestBed.createComponent(RegisterConferencierComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
