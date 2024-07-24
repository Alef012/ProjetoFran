package com.jcgontijo.paineldecontrole.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Usuario extends  Pessoa{

    @Column(nullable = false, name = "ativo")
    private Boolean ativo;

    @NotNull
    @Column(nullable = false, name = "perfil")
    @Enumerated(EnumType.STRING)
    private Perfil perfil;

    @NotNull
    @Column(nullable = false, name = "senha")
    private String senha;

    @Column(name = "foto_perfil_path")
    private String fotoPerfilPath;
}
