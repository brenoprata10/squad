import {NgModule} from '@angular/core';
import {
  MzButtonModule,
  MzCardModule,
  MzDatepickerModule,
  MzIconMdiModule,
  MzIconModule,
  MzInputModule,
  MzNavbarModule, MzToastModule
} from 'ngx-materialize';

@NgModule({
  exports: [

    MzCardModule,
    MzIconModule,
    MzInputModule,
    MzNavbarModule,
    MzButtonModule,
    MzIconMdiModule,
    MzDatepickerModule,
    MzToastModule,
  ],
  imports: [

    MzToastModule,
    MzCardModule,
    MzIconModule,
    MzInputModule,
    MzNavbarModule,
    MzButtonModule,
    MzIconMdiModule,
    MzDatepickerModule,
  ]
})
export class MaterializeModule {

}
