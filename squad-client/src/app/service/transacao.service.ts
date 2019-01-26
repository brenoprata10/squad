import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';

@Injectable()
export class TransacaoService {

  constructor(private httpClient: HttpClient) {}

  salvar(dadosFormulario) {

    return this.httpClient.post(`${environment.apiUrl}/transacao/saque`, dadosFormulario);
  }
}
