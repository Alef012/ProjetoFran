package com.ethos.gestorimobiliario.modelos.adaptadores;

import com.ethos.gestorimobiliario.modelos.Empreendimento;

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
public class EmpreendimentoAdaptador {

    private Long tipoEmpreendimentoId;

    private Long construtoraId;

    private Empreendimento empreendimento;

    
    
}
