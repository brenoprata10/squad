import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/internal/Observable';
import {Usuario} from '../model/usuario';
import {environment} from '../../environments/environment';

@Injectable()
export class UsuarioService {

  constructor(private httpClient: HttpClient) {
  }

  listarTodos(): Observable<Usuario[]> {

    return <Observable<Usuario[]>> this.httpClient.get(`${environment.apiUrl}/usuario`);
  }

}
