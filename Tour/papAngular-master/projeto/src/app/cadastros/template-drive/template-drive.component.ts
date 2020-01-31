import { Component, OnInit } from '@angular/core';
import { CadastroModel } from '../cadastro-model';

@Component({
  selector: 'app-template-drive',
  templateUrl: './template-drive.component.html',
  styleUrls: ['./template-drive.component.css']
})
export class TemplateDriveComponent implements OnInit {

  model: CadastroModel;

  constructor() {
      this.model = new CadastroModel();
  }

  ngOnInit() {
  }

}
