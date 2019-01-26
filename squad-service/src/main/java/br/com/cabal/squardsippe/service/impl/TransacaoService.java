package br.com.cabal.squardsippe.service.impl;

import java.util.Optional;

import br.com.cabal.squardsippe.model.dto.DepositoDTO;
import br.com.cabal.squardsippe.model.dto.SaqueDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cabal.squardsippe.model.Transacao;
import br.com.cabal.squardsippe.model.dto.TransacaoDTO;
import br.com.cabal.squardsippe.repository.TransacaoRepository;
import br.com.cabal.squardsippe.service.ITransacaoService;

@Service
public class TransacaoService implements ITransacaoService{

    @Autowired
    private TransacaoRepository transacaoRepository;


    public TransacaoDTO salvar(TransacaoDTO transacaoDTO) {
		Transacao transacao = new Transacao();
    	BeanUtils.copyProperties(transacaoDTO, transacao);
        this.transacaoRepository.save(transacao);
        BeanUtils.copyProperties(transacao, transacaoDTO);
        return transacaoDTO;
    }

    public TransacaoDTO buscarPorId(Long id) {
        Optional<Transacao> optional = this.transacaoRepository.findById(id);
        TransacaoDTO transacaoDTO = new TransacaoDTO();
        BeanUtils.copyProperties(optional.get(), transacaoDTO);
        return transacaoDTO;
    }

    @Override
    public void gerarSaque(SaqueDTO saqueDTO) {

        //TODO falra service banco
        Transacao transacao = new Transacao();
        this.transacaoRepository.save(transacao);
    }

    @Override
    public void gerarTransferencia(TransacaoDTO transacaoDTO) {

        //TODO falra service banco
        Transacao transacao = new Transacao();
        this.transacaoRepository.save(transacao);

    }

    @Override
    public void gerarDeposito(DepositoDTO depositoDTO) {

        //TODO falra service banco
        Transacao transacao = new Transacao();
        this.transacaoRepository.save(transacao);

    }
}
