import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/internal/Observable';
import {Extrato} from '../model/extrato';
import {environment} from '../../environments/environment';
import {Usuario} from '../model/usuario';
import {Banco} from '../model/banco';

@Injectable()
export class BancoService {

  constructor(private httpClient: HttpClient) {}

  listarTodos(): Observable<Banco[]> {

    return <Observable<Banco[]>> this.httpClient.get(`${environment.apiUrl}/banco`);
  }
}
