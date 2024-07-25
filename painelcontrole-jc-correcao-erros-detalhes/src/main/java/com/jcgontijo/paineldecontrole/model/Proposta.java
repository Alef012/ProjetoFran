package com.jcgontijo.paineldecontrole.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "proposta")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Proposta extends Entidade{

    @OneToOne
    @JoinColumn(name="cliente_id")
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name="corretor_id")
    private Corretor corretor;

    @OneToOne
    @JoinColumn(name="unidade_id")
    private Unidade unidade;

    @OneToOne
    @JoinColumn(name="situacao_id")
    private Situacao situacao;

    @OneToOne
    @JoinColumn(name="correspondente_bancario_id")
    private CorrespondenteBancario correspondente;
    
}
