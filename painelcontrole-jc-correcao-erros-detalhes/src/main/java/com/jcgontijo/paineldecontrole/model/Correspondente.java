package com.jcgontijo.paineldecontrole.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "correspondente")
@Getter
@Setter
@ToString
@Builder
public class Correspondente extends Pessoa{

    @ManyToOne
    @JoinColumn(name = "correspondente_bancario_id")
    private CorrespondenteBancario correspondenteBancario;

}
