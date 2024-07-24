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
@Table(name = "tipo_empreendimento")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class TipoEmpreendimento extends Entidade{

    @Column(nullable = false, name ="nome")
    private String nome;

    @OneToMany(mappedBy = "tipoEmpreendimento")
    private List<Empreendimento> empreendimentos;
}
