import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/internal/Observable';
import {Extrato} from '../model/extrato';
import {environment} from '../../environments/environment';

@Injectable()
export class ExtratoService {

  constructor(private httpClient: HttpClient) {}

  listarPorData(data: Date): Observable<Extrato[]> {

    return <Observable<Extrato[]>> this.httpClient.get(`${environment.apiUrl}/extrato/${data}`);
  }
}
