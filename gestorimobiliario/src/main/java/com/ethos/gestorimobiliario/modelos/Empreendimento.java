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
@Table(name = "empreendimento")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Empreendimento extends Entidade{

    @Column(nullable = false, name = "nome")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "tipo_empreendimento_id")
    TipoEmpreendimento tipoEmpreendimento;

    @ManyToOne
    @JoinColumn(name = "construtora_id")
    private Construtora construtora;

}
