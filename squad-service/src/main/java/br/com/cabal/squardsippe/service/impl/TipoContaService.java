package br.com.cabal.squardsippe.service.impl;

import br.com.cabal.squardsippe.model.dto.TipoContaDTO;
import br.com.cabal.squardsippe.repository.TipoContaRepository;
import br.com.cabal.squardsippe.service.ITipoContaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipoContaService implements ITipoContaService {

    @Autowired
    private TipoContaRepository tipoContaRepository;

    @Override
    public List<TipoContaDTO> listar() {
        return this.tipoContaRepository.buscarTodos();
    }
}
