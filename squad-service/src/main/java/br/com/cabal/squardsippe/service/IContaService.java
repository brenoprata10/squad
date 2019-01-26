package br.com.cabal.squardsippe.service;

import br.com.cabal.squardsippe.model.dto.ContaDTO;

import java.util.List;

public interface IContaService {

    List<ContaDTO> listar();

    ContaDTO salvar(ContaDTO agenciaDTO);
}
