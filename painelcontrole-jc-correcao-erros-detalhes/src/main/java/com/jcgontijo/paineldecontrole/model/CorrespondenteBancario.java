package com.jcgontijo.paineldecontrole.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "correspondente_bancario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CorrespondenteBancario extends Entidade{

    @Column(nullable = false, name ="nome")
    String nome;

    @OneToMany(mappedBy = "correspondenteBancario")
    List<Correspondente> correspondentes;
}
