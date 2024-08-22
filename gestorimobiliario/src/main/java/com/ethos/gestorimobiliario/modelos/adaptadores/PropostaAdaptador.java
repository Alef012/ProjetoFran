package com.ethos.gestorimobiliario.modelos.adaptadores;

import com.ethos.gestorimobiliario.modelos.Proposta;

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
public class PropostaAdaptador {
    private Proposta proposta;
    private Long clienteId;
    private Long corretorId;
    private Long unidadeId;
    private Long situacaoId;
    private Long correspondenteBancarioId;
    
}
