package br.com.cabal.squardsippe.controller;

import br.com.cabal.squardsippe.model.dto.DepositoDTO;
import br.com.cabal.squardsippe.model.dto.SaqueDTO;
import br.com.cabal.squardsippe.model.dto.TransacaoDTO;
import br.com.cabal.squardsippe.service.ITransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "transacao/api")
public class TransacaoController {

    @Autowired
    private ITransacaoService transacaoService;

    @GetMapping(value = "/extrato/{dataInicio}/{dataFim}/{numeroConta}")
    public List<Object> gerarExtrato(@PathVariable LocalDate dataInicio, @PathVariable LocalDate dataFim, @PathVariable String numeroConta) {

        return Arrays.asList();
    }

    @PostMapping(value = "/saque")
    public void gerarSaque(@RequestBody SaqueDTO saqueDTO) {

        TransacaoDTO transacaoDTO = new TransacaoDTO();
        this.transacaoService.salvar(transacaoDTO);

    }

    @PostMapping(value = "/transferencia")
    public void gerarTransferencia(@RequestBody TransacaoDTO transacaoDTO) {

    }

    @PostMapping(value = "/deposito")
    public void gerarDeposito(@RequestBody DepositoDTO depositoDTO) {

    }

}
