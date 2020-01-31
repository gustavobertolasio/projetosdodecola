import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BoloStoreService {
  private bolosSubject$: BehaviorSubject<string[]>;
  public listaBolos$: Observable<string[]>;

  constructor() {
    this.bolosSubject$ = new BehaviorSubject<string[]>(['Cenoura', 'Leite Ninho', 'Chocolate']);
    this.listaBolos$ = this.bolosSubject$.asObservable();
  }

  adicionar(novo: string): void {
    const array = this.bolosSubject$.getValue();
    array.push(novo);
    this.bolosSubject$.next(array);
  }
}
