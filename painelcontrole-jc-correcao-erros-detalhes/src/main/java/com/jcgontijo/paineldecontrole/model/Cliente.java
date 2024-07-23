package com.jcgontijo.paineldecontrole.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="cliente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

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
    
}
