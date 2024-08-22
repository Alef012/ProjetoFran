package com.ethos.gestorimobiliario.modelos.adaptadores;

import com.ethos.gestorimobiliario.modelos.Unidade;

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
public class UnidadeAdaptador {
    
    Unidade unidade;

    Long empreendimentoId;
}
