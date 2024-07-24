package com.jcgontijo.paineldecontrole.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="construtora")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Construtora extends Entidade{
    
    @Column(nullable = false, name = "nome")
    private String nome;

    @Column(nullable = false, name = "cnpj")
    private String cnpj;

    @OneToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @OneToOne
    @JoinColumn(name = "gerente_id")
    private Gerente gerente;

    @OneToOne
    @JoinColumn(name = "financeiro_id")
    private Financeiro financeiro;

    @OneToMany(mappedBy = "construtora")
    private List<Empreendimento> empreendimentos;
}
