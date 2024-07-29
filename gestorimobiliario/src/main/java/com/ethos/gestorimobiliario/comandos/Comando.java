package com.ethos.gestorimobiliario.comandos;

public interface Comando<T> {
    T executar();
}
