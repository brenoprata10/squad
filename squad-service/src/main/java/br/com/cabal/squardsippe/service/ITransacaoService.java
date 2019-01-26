package br.com.cabal.squardsippe.service;

import br.com.cabal.squardsippe.model.dto.TransacaoDTO;

public interface ITransacaoService {

	TransacaoDTO salvar(TransacaoDTO transacaoDTO);

	TransacaoDTO buscarPorId(Long id);
}
