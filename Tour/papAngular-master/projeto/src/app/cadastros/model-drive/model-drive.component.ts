import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { CustomValidatorsService } from '../custom-validators.service';

@Component({
  selector: 'app-model-drive',
  templateUrl: './model-drive.component.html',
  styleUrls: ['./model-drive.component.css']
})
export class ModelDriveComponent implements OnInit {

  pageForm: FormGroup;

  constructor(private fb: FormBuilder, private customValidators: CustomValidatorsService) {
    this.createForm();
  }

  ngOnInit() {
  }

  createForm() {
    this.pageForm = this.fb.group({
      nome: ['', Validators.required], // valor padrão, validadores
      endereco: ['', Validators.required],
      idade: ['', [Validators.required, Validators.min(16)]],
      cep: ['', [Validators.required ], this.customValidators.cep.bind(this.customValidators)]
    });
  }

}
