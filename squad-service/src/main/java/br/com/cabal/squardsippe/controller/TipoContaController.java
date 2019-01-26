package br.com.cabal.squardsippe.controller;

import br.com.cabal.squardsippe.model.dto.TipoContaDTO;
import br.com.cabal.squardsippe.service.impl.TipoContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tipo-conta/")
public class TipoContaController {

    @Autowired
    private TipoContaService tipoContaService;

    @GetMapping
    public List<TipoContaDTO> listar() {
        return tipoContaService.listar();
    }

}