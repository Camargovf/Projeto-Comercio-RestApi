package com.algaw.mercado.api.model;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class OcorrenciaModel {

    private Long id;
    private String descricao;
    private OffsetDateTime dataRegistro;

}
