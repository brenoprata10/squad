package br.com.cabal.squardsippe.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ExtratoDTO implements Serializable {

    public List<ItemExtratoDTO> items;
    public BigDecimal saldo;
}
