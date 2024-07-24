package com.jcgontijo.paineldecontrole.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "gerente")
@Getter
@Setter
@ToString
@Builder
public class Gerente extends Pessoa{

    @OneToOne(mappedBy = "gerente")
    private Construtora construtora;
}
