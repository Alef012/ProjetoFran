package com.jcgontijo.paineldecontrole.model;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa extends Entidade{
    
    @Column(nullable = false, name ="nome")
    private String nome;

    @Column(nullable = false, name ="cpf")
    private String cpf;

    @Column(nullable = false, name ="email")
    private String email;
    
    @Column(nullable = false, name ="telefone")
    private String telefone;

    @Column(nullable = true, name ="whatsapp")
    private String whatsapp;

    @Column(nullable= true, name="observacao")
    private String observacao;

    @Column(nullable=true,name="instagram")
    private String instagram;

    @Column(nullable = true,name="facebook")
    private String facebook;

    @OneToOne
    @JoinColumn(name = "endereco_id") 
    private Endereco endereco;
}
