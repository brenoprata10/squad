package br.com.cabal.squardsippe.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class DepositoDTO implements Serializable {

    private Long codidoUsuario;
    private String conta;
    private String numeroConta;
    private Long codigoBanco;

}
