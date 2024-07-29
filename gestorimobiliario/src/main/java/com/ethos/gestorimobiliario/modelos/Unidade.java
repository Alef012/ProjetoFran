package com.ethos.gestorimobiliario.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "unidade")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Unidade extends Entidade{

    @Column(name = "andar")
    private String andar;

    @Column(name = "bloco")
    private String bloco;

    @Column(name = "numero")
    private String numero;

    @Column(name = "quadra")
    private String quadra;

    @ManyToOne
    @JoinColumn(name = "empreendimento_id")
    private Empreendimento empreendimento;

    @Column(name = "area")
    private Double area;
    
}
