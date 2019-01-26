package br.com.cabal.squardsippe.service.impl;

import br.com.cabal.squardsippe.exception.ObjectNotFoundException;
import br.com.cabal.squardsippe.model.Conta;
import br.com.cabal.squardsippe.model.Usuario;
import br.com.cabal.squardsippe.model.dto.ContaDTO;
import br.com.cabal.squardsippe.model.dto.UsuarioDTO;
import br.com.cabal.squardsippe.repository.ContaRepository;
import br.com.cabal.squardsippe.service.IContaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContaService implements IContaService {

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private UsuarioService usuarioService;

    public List<ContaDTO> listar() {
        List<ContaDTO> contaDTOS = new ArrayList<>();
        this.contaRepository.findAll().forEach(conta -> {
            ContaDTO contaDTO = new ContaDTO();
            BeanUtils.copyProperties(conta, contaDTO);
            contaDTOS.add(contaDTO);
        });
        return contaDTOS;
    }

    @Override
    public ContaDTO salvar(ContaDTO contaDTO) {
        Conta conta = new Conta();
        BeanUtils.copyProperties(contaDTO, conta);
        this.contaRepository.save(conta);
        BeanUtils.copyProperties(conta, contaDTO);
        return contaDTO;
    }

    public List<ContaDTO> buscarIdUsuario(Long id) {
        List<ContaDTO> contaDTOS = new ArrayList<>();

        this.contaRepository.findByIdUsuario(id).forEach(conta -> {
            ContaDTO contaDTO = new ContaDTO();
            BeanUtils.copyProperties(conta, contaDTO);
            contaDTOS.add(contaDTO);
        });
        return contaDTOS;
    }

    @Override
    public ContaDTO buscarIdUsuarioAndContaAndAgencia(Long idUsuario, Long idConta, Long idAgencia) {

        Conta conta = this.contaRepository.buscarIdUsuarioAndContaAndAgencia(idUsuario, idConta, idAgencia);
        ContaDTO contaDTO = new ContaDTO();
        BeanUtils.copyProperties(conta, contaDTO);
        return contaDTO;
    }

    @Transactional
    public ContaDTO atualizar(ContaDTO contaDTO) {

        ValidarExisteNoBanco(contaDTO);

        Conta conta = new Conta();
        BeanUtils.copyProperties(contaDTO, conta);
        Conta contaSalva = this.contaRepository.save(conta);

        BeanUtils.copyProperties(contaSalva, contaDTO);

        return contaDTO;
    }

    private void ValidarExisteNoBanco(ContaDTO contaDTO) {
        if (exist(contaDTO.getId())) {
            throw new ObjectNotFoundException("conta com esse id não existe: " + contaDTO.getId());
        }
    }

    private boolean exist(Long id) {
        return contaRepository.existsById(id);
    }
}
