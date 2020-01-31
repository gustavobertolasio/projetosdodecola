import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PaisesDisplayComponent } from './paises-display.component';
import { Pais } from '../pais';
describe('PaisesDisplayComponent', () => {
  let component: PaisesDisplayComponent;
  let fixture: ComponentFixture<PaisesDisplayComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PaisesDisplayComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PaisesDisplayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should create with value', () => {
    component.pais = new Pais('Brasil', 'BR');
    fixture.detectChanges();
    const compiled = fixture.debugElement.nativeElement;
    expect(compiled.querySelector('span').textContent).toContain('Brasil / BR');
  });
});
