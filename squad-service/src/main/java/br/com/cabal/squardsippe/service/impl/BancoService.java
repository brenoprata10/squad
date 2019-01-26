package br.com.cabal.squardsippe.service.impl;

import br.com.cabal.squardsippe.model.dto.BancoDTO;
import br.com.cabal.squardsippe.repository.AgenciaRepository;
import br.com.cabal.squardsippe.service.IBancoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BancoService implements IBancoService {

    @Autowired
    private AgenciaRepository agenciaRepository;

    public List<BancoDTO> listar() {
        List<BancoDTO> bancoDTOS = new ArrayList<>();
        this.agenciaRepository.findAll().forEach(u -> {
            BancoDTO bancoDTO = new BancoDTO();
            BeanUtils.copyProperties(u, bancoDTO);
            bancoDTOS.add(bancoDTO);
        });
        return bancoDTOS;
    }
}
