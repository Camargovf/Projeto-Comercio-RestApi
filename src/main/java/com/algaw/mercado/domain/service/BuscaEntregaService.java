package com.algaw.mercado.domain.service;

import com.algaw.mercado.api.exceptionhandler.EntidadeNaoEncontradaException;
import com.algaw.mercado.domain.model.Entrega;
import com.algaw.mercado.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BuscaEntregaService {

    private EntregaRepository entregaRepository;

    public Entrega buscar(Long entregaId) {
        return entregaRepository.findById(entregaId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada"));
    }
}


