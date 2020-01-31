import { TestBed } from '@angular/core/testing';

import { HttpClientTestingModule } from '@angular/common/http/testing';
import { PesquisaPaisesService } from './pesquisa-paises.service';

describe('PesquisaPaisesService', () => {
  beforeEach(() => TestBed.configureTestingModule({ imports: [HttpClientTestingModule],
  providers:[PesquisaPaisesService] }));

  it('should be created', () => {
    const service: PesquisaPaisesService = TestBed.get(PesquisaPaisesService);
    expect(service).toBeTruthy();
  });
});
