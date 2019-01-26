package br.com.cabal.squardsippe.service;

import br.com.cabal.squardsippe.model.dto.UsuarioDTO;

import java.util.List;

public interface IUsuarioService {

    public List<UsuarioDTO> listar();

    public UsuarioDTO salvar(UsuarioDTO usuarioDTO);

    public UsuarioDTO buscarPorId(Long id);

    public UsuarioDTO atualizar(UsuarioDTO usuarioDTO);

}
