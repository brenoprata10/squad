package br.com.cabal.squardsippe.service.impl;

import br.com.cabal.squardsippe.model.Usuario;
import br.com.cabal.squardsippe.model.dto.UsuarioDTO;
import br.com.cabal.squardsippe.repository.UsuarioRepository;
import br.com.cabal.squardsippe.service.IUsuarioService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional(readOnly = true)
    public List<UsuarioDTO> listar() {

        List<UsuarioDTO> usuarioDTOS = new ArrayList<>();
        this.usuarioRepository.findAll().forEach(u -> {
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            BeanUtils.copyProperties(u, usuarioDTO);
            usuarioDTOS.add(usuarioDTO);
        });
        return usuarioDTOS;
    }

    @Transactional(readOnly = true)
    public UsuarioDTO salvar(UsuarioDTO usuarioDTO) {

        if (exist(usuarioDTO.getId())) {
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
        Optional<Usuario> optional = this.usuarioRepository.findById(id);
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        BeanUtils.copyProperties(optional.get(), usuarioDTO);
        return usuarioDTO;
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

    private boolean exist(Long id) {
        return usuarioRepository.existsById(id);
    }
}
