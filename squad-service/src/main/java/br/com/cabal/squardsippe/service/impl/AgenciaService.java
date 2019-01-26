package br.com.cabal.squardsippe.service.impl;

import br.com.cabal.squardsippe.model.Agencia;
import br.com.cabal.squardsippe.model.dto.AgenciaDTO;
import br.com.cabal.squardsippe.repository.AgenciaRepository;
import br.com.cabal.squardsippe.service.IAgenciaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AgenciaService implements IAgenciaService {

    @Autowired
    private AgenciaRepository agenciaRepository;

    public List<AgenciaDTO> listar() {

        List<AgenciaDTO> usuarioDTOS = new ArrayList<>();
        this.agenciaRepository.findAll().forEach(u -> {
            AgenciaDTO usuarioDTO = new AgenciaDTO();
            BeanUtils.copyProperties(u, usuarioDTO);
            usuarioDTOS.add(usuarioDTO);
        });
        return usuarioDTOS;
    }

    public AgenciaDTO salvar(AgenciaDTO usuarioDTO) {
        Agencia usuario = new Agencia();
        BeanUtils.copyProperties(usuarioDTO, usuario);
        this.agenciaRepository.save(usuario);
        BeanUtils.copyProperties(usuario, usuarioDTO);
        return usuarioDTO;
    }

    public AgenciaDTO buscarPorId(Long id) {
        Optional<Agencia> optional = this.agenciaRepository.findById(id);
        AgenciaDTO usuarioDTO = new AgenciaDTO();
        BeanUtils.copyProperties(optional.get(), usuarioDTO);
        return usuarioDTO;
    }
}
