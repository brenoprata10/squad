package br.com.cabal.squardsippe.controller;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "transacao/api")
public class TransacaoController {

    @GetMapping(value = "/extrato/{dataInicio}/{dataFim}/{numeroConta}")
    public List<Object> gerarExtrato(@PathVariable LocalDate dataInicio, @PathVariable LocalDate dataFim, @PathVariable String numeroConta) {

        return Arrays.asList();
    }

    @PostMapping(value = "/saque")
    public void gerarSaque() {

    }

    @PostMapping(value = "/transferencia")
    public void gerarTransferencia() {

    }

    @PostMapping(value = "/deposito")
    public void gerarDeposito() {

    }

}
