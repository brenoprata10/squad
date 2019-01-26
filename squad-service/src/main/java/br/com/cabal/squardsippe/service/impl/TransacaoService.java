package br.com.cabal.squardsippe.service.impl;

import br.com.cabal.squardsippe.exception.SaldoIndisponivelException;
import br.com.cabal.squardsippe.model.*;
import br.com.cabal.squardsippe.model.dto.ContaDTO;
import br.com.cabal.squardsippe.model.dto.DepositoDTO;
import br.com.cabal.squardsippe.model.dto.SaqueDTO;
import br.com.cabal.squardsippe.model.dto.TransacaoDTO;
import br.com.cabal.squardsippe.repository.TransacaoRepository;
import br.com.cabal.squardsippe.service.IBancoService;
import br.com.cabal.squardsippe.service.IContaService;
import br.com.cabal.squardsippe.service.ITransacaoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;

@Service
public class TransacaoService implements ITransacaoService{

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private IContaService contaService;


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
    public Transacao gerarSaque(SaqueDTO saqueDTO) {

        ContaDTO contaDTO = this.contaService.buscarIdUsuarioAndContaAndAgencia(saqueDTO.getCodigoUsuario(), saqueDTO.getCodigoConta(), saqueDTO.getCodigoAgencia());


        if (contaDTO.getSaldo().floatValue() < saqueDTO.getValor().floatValue()) {
            throw  new SaldoIndisponivelException("Saldo indisponivel, seu saldo em conta é de: " + contaDTO.getSaldo());
        }
        contaDTO.setSaldo(contaDTO.getSaldo().subtract(saqueDTO.getValor()));

        this.contaService.salvar(contaDTO);

        Transacao transacao = new Transacao();

        Agencia agencia = new Agencia();
        agencia.setId(saqueDTO.getCodigoAgencia());
        transacao.setAgencia(agencia);
        Banco banco = new Banco();
        banco.setId(saqueDTO.getCodigoBanco());
        transacao.setBanco(banco);
        transacao.setDataTransacao(LocalDateTime.now());
        Conta conta = new Conta();
        conta.setId(saqueDTO.getCodigoConta());
        transacao.setContaOrigem(conta);
        transacao.setSaldoAnterior(contaDTO.getSaldo().add(saqueDTO.getValor()));
        transacao.setSaldoPosterior(contaDTO.getSaldo());
        Transacao save = this.transacaoRepository.save(transacao);
        return save;
    }

    @Override
    public Transacao gerarTransferencia(TransacaoDTO transacaoDTO) {

        ContaDTO contaOrigem = this.contaService.buscarIdUsuarioAndContaAndAgencia(transacaoDTO.getCodigoUsuario(), transacaoDTO.getCodigocontaOrigem(), transacaoDTO.getCodigoAgencia());
        ContaDTO contaDestino = this.contaService.buscarIdUsuarioAndContaAndAgencia(transacaoDTO.getCodigoUsuario(), transacaoDTO.getCodigoContaDestino(), transacaoDTO.getCodigoAgencia());

        if (contaOrigem.getSaldo().floatValue() < transacaoDTO.getValor().floatValue()) {
            throw new SaldoIndisponivelException("saldo insuficiente para tranferencia, seu saldo é: " + contaOrigem.getSaldo());
        }
        contaDestino.setSaldo(contaDestino.getSaldo().add(transacaoDTO.getValor()));
        contaOrigem.setSaldo(contaDestino.getSaldo().subtract(transacaoDTO.getValor()));

        this.contaService.salvar(contaOrigem);
        this.contaService.salvar(contaDestino);

        Transacao transacao = new Transacao();


        Agencia agencia = new Agencia();
        agencia.setId(transacaoDTO.getCodigoAgencia());
        transacao.setAgencia(agencia);
        Banco banco = new Banco();
        banco.setId(transacaoDTO.getCodigoBanco());
        transacao.setBanco(banco);
        transacao.setDataTransacao(LocalDateTime.now());
        transacao.setSaldoAnterior(contaOrigem.getSaldo().add(transacaoDTO.getValor()));
        transacao.setSaldoPosterior(contaOrigem.getSaldo());
        Conta contaOrigemT = new Conta();
        contaOrigem.setId(transacaoDTO.getCodigocontaOrigem());
        transacao.setContaOrigem(contaOrigemT);
        Conta contaDestinoT = new Conta();
        contaDestinoT.setId(transacaoDTO.getCodigoContaDestino());

        Transacao save = this.transacaoRepository.save(transacao);
        return save;
    }

    @Override
    public void gerarDeposito(DepositoDTO depositoDTO) {

        //TODO falra service banco
        Transacao transacao = new Transacao();
        this.transacaoRepository.save(transacao);

    }
}
