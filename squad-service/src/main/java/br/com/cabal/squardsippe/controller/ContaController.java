package br.com.cabal.squardsippe.controller;

import br.com.cabal.squardsippe.model.dto.ContaDTO;
import br.com.cabal.squardsippe.service.impl.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/conta/")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @GetMapping
    public List<ContaDTO> listar() {
        return contaService.listar();
    }

}