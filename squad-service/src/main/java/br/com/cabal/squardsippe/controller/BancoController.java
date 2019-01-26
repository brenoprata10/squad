package br.com.cabal.squardsippe.controller;

import br.com.cabal.squardsippe.model.dto.BancoDTO;
import br.com.cabal.squardsippe.service.impl.BancoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/banco/")
public class BancoController {

    @Autowired
    private BancoService bancoService;

    @GetMapping
    public List<BancoDTO> listar() {
        return bancoService.listar();
    }
}