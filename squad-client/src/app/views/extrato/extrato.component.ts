import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {Extrato} from '../../model/extrato';
import DateOptions = Pickadate.DateOptions;
import {ExtratoService} from '../../service/extrato.service';

@Component({
  selector: 'app-extrato',

  templateUrl: './extrato.component.html'
})
export class ExtratoComponent implements OnInit {

  formConsulta: FormGroup;
  listaExtratos: Extrato[];

  constructor(private formBuilder: FormBuilder,
              private extratoService: ExtratoService) {}

  ngOnInit() {

    this.construirForm();
  }

  private construirForm() {

    this.formConsulta = this.formBuilder.group({
      'dataExtrato': new FormControl(null, Validators.required)
    });
  }

  pesquisarFiltro() {

    const dataInformada = this.formConsulta.get('dataExtrato').value;

    this.extratoService.listarPorData(dataInformada)
      .subscribe(res => {

        this.listaExtratos = res;
      });
  }
}
