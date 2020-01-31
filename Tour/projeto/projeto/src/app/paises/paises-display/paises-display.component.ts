import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Pais } from '../pais';

@Component({
  selector: 'app-paises-display',
  templateUrl: './paises-display.component.html',
  styleUrls: ['./paises-display.component.css']
})
export class PaisesDisplayComponent implements OnInit {

  @Input() pais: Pais;
  @Output() notificacao = new EventEmitter();

  constructor() { }

  ngOnInit() {
  }

  onClick() {
    console.log('Display Paises Click');
    this.notificacao.emit(this.pais);
  }

}