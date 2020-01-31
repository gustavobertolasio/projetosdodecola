import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PaisesListComponent } from './paises-list/paises-list.component';
import { PaisesDisplayComponent } from './paises-display/paises-display.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';


@NgModule({
  declarations: [PaisesListComponent, PaisesDisplayComponent],
  imports: [
    CommonModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  exports: [
    PaisesListComponent
  ]
})
export class PaisesModule { }
