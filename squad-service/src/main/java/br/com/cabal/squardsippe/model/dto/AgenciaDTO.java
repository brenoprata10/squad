package br.com.cabal.squardsippe.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Getter
@Setter
public class AgenciaDTO implements Serializable {

    private Long id;
    private String numero;

    public AgenciaDTO(Long id, String numero) {
        this.id = id;
        this.numero = numero;
    }
}
