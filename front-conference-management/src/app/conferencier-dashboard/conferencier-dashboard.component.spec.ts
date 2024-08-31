import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConferencierDashboardComponent } from './conferencier-dashboard.component';

describe('ConferencierDashboardComponent', () => {
  let component: ConferencierDashboardComponent;
  let fixture: ComponentFixture<ConferencierDashboardComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ConferencierDashboardComponent]
    });
    fixture = TestBed.createComponent(ConferencierDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
