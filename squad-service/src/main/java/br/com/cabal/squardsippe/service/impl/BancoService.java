package br.com.cabal.squardsippe.service.impl;

import br.com.cabal.squardsippe.model.dto.BancoDTO;
import br.com.cabal.squardsippe.repository.BancoRepository;
import br.com.cabal.squardsippe.service.IBancoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BancoService implements IBancoService {

    @Autowired

    private BancoRepository bancoRepository;

    @Override
    public List<BancoDTO> listar() {
        return this.bancoRepository.buscarTodos();
    }
}
