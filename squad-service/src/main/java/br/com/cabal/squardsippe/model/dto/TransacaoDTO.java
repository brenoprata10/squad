package br.com.cabal.squardsippe.model.dto;

import br.com.cabal.squardsippe.model.*;
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
public class TransacaoDTO implements Serializable {

    private Long id;
    private LocalDateTime dataTransacao;
    private BigDecimal valor;
    private BigDecimal saldoPosterior;
    private BigDecimal saldoAnterior;
    private LocalDateTime dataDebito;
    private String contaDestino;
    private String codigoAgenciaDestino;
    private Agencia agencia;
    private Banco banco;
    private Conta contaOrigem;
    private TipoMovimentacao tipoMovimentacao;
    private TipoTransacao tipoTransacao;
}
