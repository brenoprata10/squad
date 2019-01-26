package br.com.cabal.squardsippe.service.impl;

import br.com.cabal.squardsippe.model.dto.TipoMovimentacaoDTO;
import br.com.cabal.squardsippe.repository.TipoMovimentacaoRepository;
import br.com.cabal.squardsippe.service.ITipoMovimentacaoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipoTransacaoService implements ITipoMovimentacaoService {

    @Autowired
    private TipoMovimentacaoRepository tipoMovimentacaoRepository;

    @Override
    public List<TipoMovimentacaoDTO> listar() {
        return this.tipoMovimentacaoRepository.findAll().stream().map(tipoMovimentacaoConta -> {
            TipoMovimentacaoDTO tipoMovimentacaoDTO = new TipoMovimentacaoDTO();
            BeanUtils.copyProperties(tipoMovimentacaoConta, tipoMovimentacaoDTO);
            return tipoMovimentacaoDTO;
        }).collect(Collectors.toList());
    }
}
