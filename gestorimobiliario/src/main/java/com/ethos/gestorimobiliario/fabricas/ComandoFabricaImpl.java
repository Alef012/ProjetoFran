package com.ethos.gestorimobiliario.fabricas;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.ethos.gestorimobiliario.comandos.Comando;
import com.ethos.gestorimobiliario.comandos.CriarComando;
import com.ethos.gestorimobiliario.comandos.DeletarComando;
import com.ethos.gestorimobiliario.comandos.EditarComando;
import com.ethos.gestorimobiliario.enumeradores.TipoComando;

@Component
public class ComandoFabricaImpl<T, K> implements ComandoFabrica<T, K> {

    private final Map<Class<?>, CrudRepository<?, ?>> repositorios;

    @Autowired
    public ComandoFabricaImpl(Map<Class<?>, CrudRepository<?, ?>> repositorios) {
        this.repositorios = repositorios;
    }

    @Override
    public Comando<T> criaComando(TipoComando tipoComando, T entidade, K id) {
        CrudRepository<T, K> repositorio = getRepositorio(entidade.getClass());
        switch (tipoComando) {
            case CRIAR:
                return new CriarComando<>(repositorio, entidade);
            case EDITAR:
                if (id == null) {
                    throw new IllegalArgumentException("ID não pode ser nulo para o comando EDITAR");
                }
                return new EditarComando<>(repositorio, entidade, id);
            case DELETAR:
                if (id == null) {
                    throw new IllegalArgumentException("ID não pode ser nulo para o comando DELETAR");
                }
                return new DeletarComando<>(repositorio, id);
            default:
                throw new IllegalArgumentException("Tipo de comando desconhecido: " + tipoComando);
        }
    }

    @SuppressWarnings("unchecked")
    private <R> CrudRepository<T, K> getRepositorio(Class<R> clazz) {
        return (CrudRepository<T, K>) repositorios.get(clazz);
    }
}
