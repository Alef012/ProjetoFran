package com.ethos.gestorimobiliario.modelos.adaptadores;

import com.ethos.gestorimobiliario.modelos.Pessoa;

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
public class CorrespondenteAdaptador {
    
    private Long correspondenteBancarioId;
    private Pessoa pessoa;
}
