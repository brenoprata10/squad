import {NgModule} from '@angular/core';
import {SaqueComponent} from '../views/saque/saque.component';
import {MzNavbarModule} from 'ngx-materialize';

@NgModule({

  exports: [

    // Componente
    SaqueComponent,

    // Modulos
    MzNavbarModule,
  ],

  declarations: [
    SaqueComponent
  ],
  imports: [

    // Modulos
    MzNavbarModule,
  ]
})
export class GlobalSharedModule {

}
