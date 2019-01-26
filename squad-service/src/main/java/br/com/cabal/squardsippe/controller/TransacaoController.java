package br.com.cabal.squardsippe.controller;

import br.com.cabal.squardsippe.model.Transacao;
import br.com.cabal.squardsippe.model.dto.ContaDTO;
import br.com.cabal.squardsippe.model.dto.DepositoDTO;
import br.com.cabal.squardsippe.model.dto.SaqueDTO;
import br.com.cabal.squardsippe.model.dto.TransacaoDTO;
import br.com.cabal.squardsippe.service.IContaService;
import br.com.cabal.squardsippe.service.ITransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/api/transacao/")
public class TransacaoController {

    @Autowired
    private ITransacaoService transacaoService;

    private IContaService contaService;

    @GetMapping(value = "/extrato/{dataInicio}/{dataFim}/{numeroConta}")
    public List<Object> gerarExtrato(@PathVariable LocalDate dataInicio, @PathVariable LocalDate dataFim, @PathVariable String numeroConta) {

        return Arrays.asList();
    }

    @CrossOrigin
    @PostMapping(value = "/saque")
    public Transacao gerarSaque(@RequestBody SaqueDTO saqueDTO) {
        return this.transacaoService.gerarSaque(saqueDTO);
    }

    @PostMapping(value = "/transferencia")
    public Transacao gerarTransferencia(@RequestBody TransacaoDTO transacaoDTO) {
        return this.transacaoService.gerarTransferencia(transacaoDTO);
    }

    @PostMapping(value = "/deposito")
    public void gerarDeposito(@RequestBody DepositoDTO depositoDTO) {

    }

}
