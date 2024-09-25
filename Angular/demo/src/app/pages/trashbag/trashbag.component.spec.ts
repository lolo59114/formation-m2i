import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TrashbagComponent } from './trashbag.component';

describe('TrashbagComponent', () => {
  let component: TrashbagComponent;
  let fixture: ComponentFixture<TrashbagComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TrashbagComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TrashbagComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
