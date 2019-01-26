package br.com.cabal.squardsippe.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class SaqueDTO implements Serializable {

    private Long codigoUsuario;
    private BigDecimal Valor;
    private Long codigoConta;
    private Long codigoAgencia;
    private Long codigoBanco;
}
