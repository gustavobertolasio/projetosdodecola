import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { AbstractControl } from '@angular/forms';
import { map, catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CustomValidatorsService {
  constructor(private http: HttpClient) { }

  public cep(control: AbstractControl): Observable<{ [key: string]: any } | null> {
    let cepValue: string = control.value;

    if (cepValue.length < 8) {
      return of({ cep: true });
    }

    cepValue = cepValue.replace('-', '');

    if (cepValue.length > 8) {
      return of({ cep: true });
    }

    return this.http.get(`https://viacep.com.br/ws/${cepValue}/json`).pipe(
      map((resp) => {
        if (resp['erro']) {
          return { cep: true };
        } else {
          return null;
        }
      }),
      catchError(
        (e, c) => {
          return of({ cep: true });
        }
      ));
  }
}
