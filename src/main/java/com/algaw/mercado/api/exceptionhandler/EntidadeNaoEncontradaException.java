package com.algaw.mercado.api.exceptionhandler;

import com.algaw.mercado.domain.exception.NegocioException;

public class EntidadeNaoEncontradaException extends NegocioException {

    private static final long serialVersionUID = 1L;

    public EntidadeNaoEncontradaException(String message) {
        super(message);
    }

}