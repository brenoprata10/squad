package br.com.cabal.squardsippe.controller;

import br.com.cabal.squardsippe.model.dto.TipoTransacaoDTO;
import br.com.cabal.squardsippe.service.impl.TipoTransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tipo-movimentacao/")
public class TipoTransacaoController {

    @Autowired
    private TipoTransacaoService tipoTransacaoService;



}