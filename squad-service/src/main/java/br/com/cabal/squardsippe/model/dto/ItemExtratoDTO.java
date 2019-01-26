package br.com.cabal.squardsippe.model.dto;

import br.com.cabal.squardsippe.model.TipoTransacao;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class ItemExtratoDTO implements Serializable {

    private LocalDateTime data;
    private String descricao;
    private BigDecimal valor;
    private TipoTransacao tipoTransacao;
}
