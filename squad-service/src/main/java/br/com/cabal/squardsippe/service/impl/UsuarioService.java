package br.com.cabal.squardsippe.service.impl;

import br.com.cabal.squardsippe.model.Usuario;
import br.com.cabal.squardsippe.model.dto.UsuarioDTO;
import br.com.cabal.squardsippe.repository.UsuarioRepository;
import br.com.cabal.squardsippe.service.IUsuarioService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService implements IUsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Transactional(readOnly = true)
	public List<UsuarioDTO> listar() {

		return usuarioRepository.listar();
	}

	@Transactional(readOnly = true)
	public UsuarioDTO salvar(UsuarioDTO usuarioDTO) {

		if (usuarioDTO.getId() != null && exist(usuarioDTO.getId())) {
			throw new RuntimeException("Usuário já está cadastrado no banco de dados" + usuarioDTO.getId());
		}

		Usuario usuario = new Usuario();
		BeanUtils.copyProperties(usuarioDTO, usuario);
		this.usuarioRepository.save(usuario);
		BeanUtils.copyProperties(usuario, usuarioDTO);
		return usuarioDTO;
	}

	@Transactional(readOnly = true)
	public UsuarioDTO buscarPorId(Long id) {

		if (!exist(id)) {
			throw new RuntimeException("Usuario com esse id não existe: " + id);
		}
		return usuarioRepository.buscarPorId(id);
		
	}

	@Transactional
	public UsuarioDTO atualizar(UsuarioDTO usuarioDTO) {
		if (exist(usuarioDTO.getId())) {
			throw new RuntimeException("Pessoa com esse id não existe: " + usuarioDTO.getId());
		}
		Usuario usuario = new Usuario();
		BeanUtils.copyProperties(usuarioDTO, usuario);
		Usuario usuarioSalvo = this.usuarioRepository.save(usuario);

		BeanUtils.copyProperties(usuarioSalvo, usuarioDTO);

		return usuarioDTO;
	}

	@Transactional
	public void delete(UsuarioDTO usuarioDTO) {
		Usuario usuario = new Usuario();
		BeanUtils.copyProperties(usuarioDTO, usuario);
		usuarioRepository.delete(usuario);
	}

	private boolean exist(Long id) {
		return usuarioRepository.existsById(id);
	}
}
