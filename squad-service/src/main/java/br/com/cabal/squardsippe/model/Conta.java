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
@Table(name = "tb_conta", schema = "sippe")
public class Conta implements Serializable {

    private static final long serialVersionUID = 5176558673356111259L;

    @Id
    @Column(name = "cod_conta")
    private Long id;

//    @Column(name = "agencia")
//    @NotEmpty(message = )
//    private String agencia;
//
//    @
}
