package br.com.cabal.squardsippe.service.impl;

import br.com.cabal.squardsippe.model.Conta;
import br.com.cabal.squardsippe.model.dto.ContaDTO;
import br.com.cabal.squardsippe.repository.ContaRepository;
import br.com.cabal.squardsippe.service.IContaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContaService implements IContaService {

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private UsuarioService usuarioService;

    public List<ContaDTO> listar() {
        return this.contaRepository.buscarTodos();
    }

    @Override
    public ContaDTO salvar(ContaDTO contaDTO) {
        Conta conta = new Conta();
        BeanUtils.copyProperties(contaDTO, conta);
        this.contaRepository.save(conta);
        BeanUtils.copyProperties(conta, contaDTO);
        return contaDTO;
    }

    public List<ContaDTO> buscarId(Long id) {
        return this.contaRepository.findByIdUsuario(id);
    }
}
