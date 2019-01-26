package br.com.cabal.squardsippe.service;

import br.com.cabal.squardsippe.model.dto.ContaDTO;

import java.util.List;

public interface IContaService {

    List<ContaDTO> listar();

    List<ContaDTO> buscarId(Long id);

    ContaDTO salvar(ContaDTO agenciaDTO);
}
