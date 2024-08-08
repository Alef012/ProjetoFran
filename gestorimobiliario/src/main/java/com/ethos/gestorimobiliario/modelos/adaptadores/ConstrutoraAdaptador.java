package com.ethos.gestorimobiliario.modelos.adaptadores;

import com.ethos.gestorimobiliario.modelos.PessoaJuridica;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConstrutoraAdaptador {

    private Long gerenteId;
    private Long financeiroId;
    private PessoaJuridica pessoaJuridica;
}
