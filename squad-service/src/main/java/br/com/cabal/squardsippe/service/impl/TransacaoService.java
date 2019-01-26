package br.com.cabal.squardsippe.service.impl;

import br.com.cabal.squardsippe.exception.SaldoIndisponivelException;
import br.com.cabal.squardsippe.model.Agencia;
import br.com.cabal.squardsippe.model.Banco;
import br.com.cabal.squardsippe.model.Conta;
import br.com.cabal.squardsippe.model.Transacao;
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
        transacao.setSaldoAnterior(contaDTO.getSaldo().add(saqueDTO.getValor()));
        transacao.setSaldoPosterior(contaDTO.getSaldo());
        Transacao save = this.transacaoRepository.save(transacao);
        return save;
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
