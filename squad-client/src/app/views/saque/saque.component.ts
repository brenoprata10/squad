import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {BancoService} from '../../service/banco.service';
import {Banco} from '../../model/banco';
import {Router} from '@angular/router';
import {MzToastService} from 'ngx-materialize';
import {TransacaoService} from '../../service/transacao.service';

@Component({
  selector: 'app-saque',
  templateUrl: './saque.component.html'
})
export class SaqueComponent implements OnInit {

  formSaque: FormGroup;
  listaBancos: Banco[];

  constructor(private router: Router,
              private formBuilder: FormBuilder,
              private bancoService: BancoService,
              private toastService: MzToastService,
              private transacaoService: TransacaoService) {}

  ngOnInit() {

    this.inicializarListaBancos();
    this.construirForm();
  }

  private construirForm() {

    this.formSaque = this.formBuilder.group({

      'valor': new FormControl(0, Validators.required),
      'codigoConta': new FormControl(null, Validators.required),
      'codigoAgencia': new FormControl(null, Validators.required),
      'codigoBanco': new FormControl('', Validators.required)
    });
  }

  private inicializarListaBancos() {

    this.bancoService.listarTodos()
      .subscribe(res => {
        this.listaBancos = res;
      });
  }

  efetuarSaque() {

    console.log(this.formSaque.value);

    if (this.formSaque.invalid) {

      this.toastService.show('Existem campos obrigatórios não preenchidos!', 2000);
    }

    this.transacaoService.salvar(this.formSaque.value)
      .subscribe(() => {

        this.toastService.show('Saque efetuado com sucesso', 2000);
      });

  }

  voltarParaTelaExtrato() {

    this.router.navigate(['/']);
  }

}
