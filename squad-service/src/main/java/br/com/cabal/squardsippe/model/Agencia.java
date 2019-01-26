package br.com.cabal.squardsippe.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Getter
@Setter
@Table(name = "tb_agencia", schema = "sippe")
public class Agencia implements Serializable {

    private static final long serialVersionUID = 8136199070223847855L;

    @Id
    @Column(name = "cod_agencia")
    private Long id;

    @Column(name = "numero")
    @NotEmpty(message = "O número não pode ser vazio")
    private String numero;
}
