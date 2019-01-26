package br.com.cabal.squardsippe.model.dto;

import br.com.cabal.squardsippe.model.Agencia;
import br.com.cabal.squardsippe.model.TipoConta;
import br.com.cabal.squardsippe.model.Usuario;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class ContaDTO implements Serializable {

    private Long id;
    private String numeroConta;
    private BigDecimal saldo;
    private Boolean ativa;
    private LocalDateTime dataAtualizacao;
    private Usuario usuario;
    private TipoConta tipoConta;
    private Agencia agencia;

    public ContaDTO(Long id, String numeroConta, BigDecimal saldo, Boolean ativa, LocalDateTime dataAtualizacao, Usuario usuario, TipoConta tipoConta, Agencia agencia) {
        this.id = id;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.ativa = ativa;
        this.dataAtualizacao = dataAtualizacao;
        this.usuario = usuario;
        this.tipoConta = tipoConta;
        this.agencia = agencia;
    }

    public ContaDTO() {
    }
}
