import { TestBed } from '@angular/core/testing';

import { BoloStoreService } from './bolo-store.service';

describe('BoloStoreService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: BoloStoreService = TestBed.get(BoloStoreService);
    expect(service).toBeTruthy();
  });
});
