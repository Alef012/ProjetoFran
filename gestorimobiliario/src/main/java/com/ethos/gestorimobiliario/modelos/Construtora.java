package com.ethos.gestorimobiliario.modelos;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
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
public class Construtora extends PessoaJuridica{
    
    @OneToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @OneToOne
    @JoinColumn(name = "gerente_id")
    private Gerente gerente;

    @OneToOne
    @JoinColumn(name = "financeiro_id")
    private Financeiro financeiro;

    
}
