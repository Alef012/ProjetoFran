package com.jcgontijo.paineldecontrole.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name="endereco")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Endereco extends Entidade{


    @Column(name = "cep")
    String cep;

    @Column(name = "bairro")
    String bairro;

    @Column(name = "cidade")
    String cidade;

    @Column(name = "logradouro")
    String logradouro;

    @Column(name = "numero")
    String numero;

    @Column(name = "complemento")
    String complemento;

    @OneToOne(mappedBy = "endereco")
    private Pessoa pessoa;

    @OneToOne(mappedBy = "endereco")
    private Construtora construtora;

}
