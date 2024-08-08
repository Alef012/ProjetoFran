package com.ethos.gestorimobiliario.servicos.correspondenteBancario;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ethos.gestorimobiliario.excecoes.EntidadeNaoEncontradaExcecao;
import com.ethos.gestorimobiliario.servicos.Servico;

@Service
public class CorrespondenteBancario implements Servico<CorrespondenteBancario,Long,CorrespondenteBancario>{

    @Override
    public CorrespondenteBancario criar(CorrespondenteBancario entidade) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'criar'");
    }

    @Override
    public CorrespondenteBancario obterPorId(Long id) throws EntidadeNaoEncontradaExcecao {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obterPorId'");
    }

    @Override
    public List<CorrespondenteBancario> obterTodos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obterTodos'");
    }

    @Override
    public Page<CorrespondenteBancario> listarPaginado(Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarPaginado'");
    }

    @Override
    public CorrespondenteBancario atualizar(Long id, CorrespondenteBancario entidade)
            throws EntidadeNaoEncontradaExcecao {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
    }

    @Override
    public void deletar(Long id) throws EntidadeNaoEncontradaExcecao {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletar'");
    }
    
}
