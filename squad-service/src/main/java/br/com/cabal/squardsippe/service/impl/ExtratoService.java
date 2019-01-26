package br.com.cabal.squardsippe.service.impl;

import br.com.cabal.squardsippe.model.dto.ExtratoDTO;
import br.com.cabal.squardsippe.model.dto.ItemExtratoDTO;
import br.com.cabal.squardsippe.model.dto.TransacaoDTO;
import br.com.cabal.squardsippe.repository.TransacaoRepository;
import br.com.cabal.squardsippe.service.IExtratoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExtratoService implements IExtratoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Override
    public ExtratoDTO obter() {

        ExtratoDTO extrato = new ExtratoDTO();
        BigDecimal saldo = BigDecimal.valueOf(0);

        extrato.items = this.transacaoRepository.findAll().stream().map(u -> {
            TransacaoDTO transacaoDTO = new TransacaoDTO();
            BeanUtils.copyProperties(u, transacaoDTO);

            ItemExtratoDTO itemExtratoDTO = new ItemExtratoDTO();

            itemExtratoDTO.setData(transacaoDTO.getDataTransacao());
            itemExtratoDTO.setDescricao(this.getDescricao(transacaoDTO));
            itemExtratoDTO.setValor(transacaoDTO.getValor());
            itemExtratoDTO.setTipoTransacao(transacaoDTO.getTipoTransacao());

            extrato.saldo = transacaoDTO.getSaldoPosterior();

            return itemExtratoDTO;
        }).collect(Collectors.toList());

        return extrato;
    }

    private String getDescricao(TransacaoDTO transacaoDTO) {
        StringBuilder builder = new StringBuilder();

        builder.append(transacaoDTO.getTipoMovimentacao());
        builder.append(" ");

        builder.append(transacaoDTO.getTipoMovimentacao().getNome());
        builder.append(transacaoDTO.getContaOrigem().getAgencia().getNumero());
        builder.append(transacaoDTO.getContaOrigem().getNumeroConta());

        return builder.toString();
    }
}
