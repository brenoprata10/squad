package br.com.cabal.squardsippe.service.impl;

import br.com.cabal.squardsippe.model.Agencia;
import br.com.cabal.squardsippe.model.dto.AgenciaDTO;
import br.com.cabal.squardsippe.repository.AgenciaRepository;
import br.com.cabal.squardsippe.service.IAgenciaService;
import org.hibernate.ObjectNotFoundException;
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
       return agenciaRepository.buscarTodos();
    }

    public AgenciaDTO salvar(AgenciaDTO agenciaDTO) {
        Agencia agencia = new Agencia();
        BeanUtils.copyProperties(agenciaDTO, agencia);
        this.agenciaRepository.save(agencia);
        BeanUtils.copyProperties(agencia, agenciaDTO);
        return agenciaDTO;
    }

    public AgenciaDTO buscarPorId(Long id) {
        Optional<Agencia> optional = this.agenciaRepository.findById(id);
        AgenciaDTO agenciaDTO = new AgenciaDTO();
        BeanUtils.copyProperties(optional.get(), agenciaDTO);
        return agenciaDTO;
    }
}
