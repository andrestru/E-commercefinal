import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IdfinderComponent } from './idfinder.component';

describe('IdfinderComponent', () => {
  let component: IdfinderComponent;
  let fixture: ComponentFixture<IdfinderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IdfinderComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(IdfinderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
