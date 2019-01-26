package br.com.cabal.squardsippe.controller;

import br.com.cabal.squardsippe.model.dto.TipoMovimentacaoDTO;
import br.com.cabal.squardsippe.service.impl.TipoMovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tipo-movimentacao/")
public class TipoMovimentacaoController {

    @Autowired
    private TipoMovimentacaoService tipoMovimentacaoService;

    @GetMapping
    public List<TipoMovimentacaoDTO> listar() {
        return tipoMovimentacaoService.listar();
    }

}