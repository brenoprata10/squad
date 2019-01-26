package br.com.cabal.squardsippe.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "tb_tipo_transacao", schema = "sippe")
public class TipoTransacao implements Serializable {

    private static final long serialVersionUID = 4817277524751003306L;

    @Id
    @Column(name = "cod_tipo_transacao")
    private Long id;

    @Column(name = "nome")
    @NotEmpty(message = "O nome não pode ser vazio")
    private String nome;
}
