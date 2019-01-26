import {NgModule} from '@angular/core';
import {GlobalSharedModule} from '../../global/global-shared.module';
import {ExtratoComponent} from './extrato.component';

@NgModule({
  exports: [

    ExtratoComponent
  ],
  imports: [

    GlobalSharedModule
  ],
  declarations: [

    ExtratoComponent
  ]
})
export class ExtratoModule {

}
