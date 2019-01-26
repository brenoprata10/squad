package br.com.cabal.squardsippe.service;

import br.com.cabal.squardsippe.model.dto.ContaDTO;

import java.util.List;

public interface IContaService {

    List<ContaDTO> listar();

    List<ContaDTO> buscarIdUsuario(Long id);

    ContaDTO buscarIdUsuarioAndContaAndAgencia(Long idUsuario, Long idConta, Long idAgencia);

    ContaDTO salvar(ContaDTO agenciaDTO);
}
