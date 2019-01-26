package br.com.cabal.squardsippe.model.dto;

import br.com.cabal.squardsippe.model.TipoTransacao;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class TranferenciaDTO implements Serializable {

    private Long codigoUsuario;
    private BigDecimal valor;
    private LocalDate data;
    private String contaOrigem;
    private String agenciaOrigem;
    private Long codigoBancoOrigem;
    private TipoTransacao tipoTransacao;
    private Long codigoBancoDestino;
    private String contaDestino;
    private String agenciaDestino;



}
