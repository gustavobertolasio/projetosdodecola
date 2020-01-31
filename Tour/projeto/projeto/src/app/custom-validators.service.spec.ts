import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { of } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { FormControl } from '@angular/forms';
import { CustomValidatorsService } from './custom-validators.service';

describe('CustomValidatorsService', () => {
  let mockHttpClient: HttpClient;

  beforeEach(() => TestBed.configureTestingModule({
    imports: [HttpClientTestingModule]
  }));

  it('should be created', () => {
    const service: CustomValidatorsService = TestBed.get(CustomValidatorsService);
    expect(service).toBeTruthy();
  });
  it('should be not valid', () => {
    const service: CustomValidatorsService = TestBed.get(CustomValidatorsService);

    const formCtrl = new FormControl('08760');
    let respostaParaTeste: { [key: string]: any } | null;

    service.cep(formCtrl).subscribe(resposta => respostaParaTeste = resposta);

    expect(respostaParaTeste).toBeTruthy();
    expect(respostaParaTeste.cep).toBe(true);
  });

  it('should be valid 85010-981', () => {
    mockHttpClient = TestBed.get(HttpClient);
    spyOn(mockHttpClient, 'get').and.returnValue(of({}));

    const service: CustomValidatorsService = TestBed.get(CustomValidatorsService);

    const formCtrl = new FormControl('85010-981');
    let respostaParaTeste: { [key: string]: any } | null;

    service.cep(formCtrl).subscribe(resposta => respostaParaTeste = resposta);

    expect(respostaParaTeste).toBeNull();
  });

  it('should be valid 85010981', () => {
    mockHttpClient = TestBed.get(HttpClient);
    spyOn(mockHttpClient, 'get').and.returnValue(of({}));

    const service: CustomValidatorsService = TestBed.get(CustomValidatorsService);

    const formCtrl = new FormControl('85010981');
    let respostaParaTeste: { [key: string]: any } | null;

    service.cep(formCtrl).subscribe(resposta => respostaParaTeste = resposta);

    expect(respostaParaTeste).toBeNull();
  });

  it('should be not valid with return', () => {
    mockHttpClient = TestBed.get(HttpClient);
    spyOn(mockHttpClient, 'get').and.returnValue(of({ erro: true }));

    const service: CustomValidatorsService = TestBed.get(CustomValidatorsService);

    const formCtrl = new FormControl('85010982');
    let respostaParaTeste: { [key: string]: any } | null;

    service.cep(formCtrl).subscribe(resposta => respostaParaTeste = resposta);

    expect(respostaParaTeste).toBeTruthy();
    expect(respostaParaTeste.cep).toBe(true);
  });

  it('should be not valid with exception', () => {
    let http = TestBed.get(HttpTestingController);
    let response: any;
    let errResponse: any;
    const mockErrorResponse = { status: 404, statusText: 'not found' };
    const data = 'Invalid request parameters';

    const service: CustomValidatorsService = TestBed.get(CustomValidatorsService);

    const formCtrl = new FormControl('85010982');
    let respostaParaTeste: { [key: string]: any } | null;

    service.cep(formCtrl).subscribe(resposta => respostaParaTeste = resposta);

    http.expectOne(`https://viacep.com.br/ws/${formCtrl.value}/json`).flush(data, mockErrorResponse);

    expect(respostaParaTeste).toBeTruthy();
    expect(respostaParaTeste.cep).toBe(true);
  });




});
