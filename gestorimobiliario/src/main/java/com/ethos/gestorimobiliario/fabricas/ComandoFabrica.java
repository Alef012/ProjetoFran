package com.ethos.gestorimobiliario.fabricas;


import org.springframework.stereotype.Component;

import com.ethos.gestorimobiliario.comandos.Comando;
import com.ethos.gestorimobiliario.enumeradores.TipoComando;

@Component
public interface ComandoFabrica<T,K> {
    Comando<T> criaComando(TipoComando tipoCommando,T entidade,K id);
}
