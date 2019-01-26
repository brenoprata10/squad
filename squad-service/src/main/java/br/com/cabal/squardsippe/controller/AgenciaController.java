package br.com.cabal.squardsippe.controller;

import br.com.cabal.squardsippe.model.dto.AgenciaDTO;
import br.com.cabal.squardsippe.service.impl.AgenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/agencia/")
public class AgenciaController {

    @Autowired
    private AgenciaService agenciaService;

    @GetMapping
    public List<AgenciaDTO> listar() {
        return agenciaService.listar();
    }
}