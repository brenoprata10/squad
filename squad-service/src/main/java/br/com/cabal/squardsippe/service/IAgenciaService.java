package br.com.cabal.squardsippe.service;

import br.com.cabal.squardsippe.model.dto.AgenciaDTO;

import java.util.List;

public interface IAgenciaService {

    List<AgenciaDTO> listar();

    AgenciaDTO salvar(AgenciaDTO usuarioDTO);

    AgenciaDTO buscarPorId(Long id);
}
