import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import {RouterModule} from '@angular/router';
import {AppRoutes} from './app.routes';
import {SaqueComponent} from './views/saque/saque.component';
import {MzNavbarModule} from 'ngx-materialize';
import {GlobalSharedModule} from './global/global-shared.module';


@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    GlobalSharedModule,
    RouterModule.forRoot(AppRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
