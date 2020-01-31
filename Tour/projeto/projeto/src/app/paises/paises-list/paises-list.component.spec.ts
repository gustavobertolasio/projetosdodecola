import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PaisesListComponent } from './paises-list.component';
import { PaisesDisplayComponent } from '../paises-display/paises-display.component';
import { PesquisaPaisesService } from '../pesquisa-paises.service';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
describe('PaisesListComponent', () => {
  let component: PaisesListComponent;
  let fixture: ComponentFixture<PaisesListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [PaisesListComponent, PaisesDisplayComponent],
      providers: [PesquisaPaisesService],
      imports: [HttpClientTestingModule,FormsModule, ReactiveFormsModule]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PaisesListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
