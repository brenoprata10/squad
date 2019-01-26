package br.com.cabal.squardsippe.service.impl;

import br.com.cabal.squardsippe.exception.ObjectAlreadyExistException;
import br.com.cabal.squardsippe.exception.ObjectNotFoundException;
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

        return this.usuarioRepository.findAll().stream().map(u -> {
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            BeanUtils.copyProperties(u, usuarioDTO);
            return usuarioDTO;
        }).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public UsuarioDTO salvar(UsuarioDTO usuarioDTO) {

        if (usuarioDTO.getId() != null && exist(usuarioDTO.getId())) {
            throw new ObjectAlreadyExistException("Usuário já está cadastrado no banco de dados" + usuarioDTO.getId());
        }
        
        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioDTO, usuario);
        this.usuarioRepository.save(usuario);
        BeanUtils.copyProperties(usuario, usuarioDTO);
        return usuarioDTO;
    }

    @Transactional(readOnly = true)
    public UsuarioDTO buscarPorId(Long id) {

        if(!exist(id)){
            throw new ObjectNotFoundException("Usuario com esse id não existe: " + id);
        }

        Optional<Usuario> optional = this.usuarioRepository.findById(id);
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        BeanUtils.copyProperties(optional.get(), usuarioDTO);
        return usuarioDTO;
    }

    @Transactional
    public UsuarioDTO atualizar(UsuarioDTO usuarioDTO) {

        ValidarExisteNoBanco(usuarioDTO);

        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioDTO, usuario);
        Usuario usuarioSalvo = this.usuarioRepository.save(usuario);

        BeanUtils.copyProperties(usuarioSalvo, usuarioDTO);

        return usuarioDTO;
    }

    @Transactional
    public void delete(UsuarioDTO usuarioDTO) {

        ValidarExisteNoBanco(usuarioDTO);

        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioDTO, usuario);
        usuarioRepository.delete(usuario);
    }

    private void ValidarExisteNoBanco(UsuarioDTO usuarioDTO) {
        if (exist(usuarioDTO.getId())) {
            throw new ObjectNotFoundException("Pessoa com esse id não existe: " + usuarioDTO.getId());
        }
    }

    private boolean exist(Long id) {
        return usuarioRepository.existsById(id);
    }
}
