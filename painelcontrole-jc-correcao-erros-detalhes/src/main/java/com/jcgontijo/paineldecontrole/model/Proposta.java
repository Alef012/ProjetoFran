package com.jcgontijo.paineldecontrole.model;

import javax.persistence.Entity;
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
    private Cliente cliente;
    private Corretor corretor;
    private Unidade unidade;
    private Situacao situacao;
    private CorrespondenteBancario correspondente;
    

}
