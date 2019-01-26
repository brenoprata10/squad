package br.com.cabal.squardsippe;

import br.com.cabal.squardsippe.model.Usuario;
import br.com.cabal.squardsippe.model.dto.UsuarioDTO;
import br.com.cabal.squardsippe.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> listar() {

        List<UsuarioDTO> usuarioDTOS = new ArrayList<>();
        this.usuarioRepository.findAll().forEach(u -> {
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            BeanUtils.copyProperties(u, usuarioDTO);
            usuarioDTOS.add(usuarioDTO);
        });
        return usuarioDTOS;
    }

    public UsuarioDTO salvar(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioDTO, usuario);
        this.usuarioRepository.save(usuario);
        BeanUtils.copyProperties(usuario, usuarioDTO);
        return usuarioDTO;
    }

    public UsuarioDTO buscarPorId(Long id) {
        Optional<Usuario> optional = this.usuarioRepository.findById(id);
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        BeanUtils.copyProperties(optional.get(), usuarioDTO);
        return usuarioDTO;
    }
}
