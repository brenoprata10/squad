import {NgModule} from '@angular/core';
import {SaqueComponent} from '../views/saque/saque.component';
import {MaterializeModule} from '../utils/materialize.module';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {ExtratoService} from '../service/extrato.service';
import {CommonModule} from '@angular/common';
import {UsuarioService} from '../service/usuario.service';
import {BancoService} from '../service/banco.service';
import {MzSelectModule} from 'ngx-materialize';
import {TransacaoService} from '../service/transacao.service';

@NgModule({

  exports: [

    // Componentes
    SaqueComponent,

    // Modulos
    FormsModule,
    CommonModule,
    MzSelectModule,
    HttpClientModule,
    MaterializeModule,
    ReactiveFormsModule,
  ],

  declarations: [

    SaqueComponent,
  ],
  imports: [
    FormsModule,
    CommonModule,
    MzSelectModule,
    HttpClientModule,
    MaterializeModule,
    ReactiveFormsModule,
  ],
  providers: [
    ExtratoService,
    UsuarioService,
    BancoService,
    TransacaoService
  ]
})
export class GlobalSharedModule {

}
