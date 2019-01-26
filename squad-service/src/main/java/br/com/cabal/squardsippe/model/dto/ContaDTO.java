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
    private Usuario usuario;
    private TipoConta tipoConta;
    private Agencia agencia;
}
