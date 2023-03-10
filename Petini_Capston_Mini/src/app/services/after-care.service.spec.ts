import { TestBed } from '@angular/core/testing';

import { AfterCareService } from './after-care.service';

describe('AfterCareService', () => {
  let service: AfterCareService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AfterCareService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
