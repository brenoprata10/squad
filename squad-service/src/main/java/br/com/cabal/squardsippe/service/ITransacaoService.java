package br.com.cabal.squardsippe.service;

import br.com.cabal.squardsippe.model.Transacao;
import br.com.cabal.squardsippe.model.dto.DepositoDTO;
import br.com.cabal.squardsippe.model.dto.SaqueDTO;
import br.com.cabal.squardsippe.model.dto.TransacaoDTO;
import org.springframework.web.bind.annotation.RequestBody;

public interface ITransacaoService {

	TransacaoDTO salvar(TransacaoDTO transacaoDTO);

	TransacaoDTO buscarPorId(Long id);

	Transacao gerarSaque(SaqueDTO saqueDTO);

	void gerarTransferencia(@RequestBody TransacaoDTO transacaoDTO);

	void gerarDeposito(@RequestBody DepositoDTO depositoDTO);
}
