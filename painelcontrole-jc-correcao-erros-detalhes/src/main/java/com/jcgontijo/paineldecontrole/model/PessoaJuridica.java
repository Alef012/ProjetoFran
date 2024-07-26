package com.jcgontijo.paineldecontrole.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PessoaJuridica extends Entidade{
    
    @Column(name ="razao_social")
    private String razaoSocial;

    @Column(name="nomeFantasia")
    private String nomeFantasia;

    @Column(name="cnpj")
    private String cnpj;

}
