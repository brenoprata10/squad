import {Routes} from '@angular/router';
import {ExtratoComponent} from './views/extrato/extrato.component';
import {SaqueComponent} from './views/saque/saque.component';

export const AppRoutes: Routes = [
  {
    path: '',
    component: ExtratoComponent
  },

  {
    path: 'saque',
    component: SaqueComponent
  }
];
