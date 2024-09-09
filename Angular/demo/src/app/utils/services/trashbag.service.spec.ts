import { TestBed } from '@angular/core/testing';

import { TrashbagService } from './trashbag.service';

describe('TrashbagService', () => {
  let service: TrashbagService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TrashbagService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
