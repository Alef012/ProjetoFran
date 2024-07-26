package com.jcgontijo.paineldecontrole.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "correspondente_bancario")
@Getter
@Setter
@ToString
public class CorrespondenteBancario extends PessoaJuridica{
        
}
