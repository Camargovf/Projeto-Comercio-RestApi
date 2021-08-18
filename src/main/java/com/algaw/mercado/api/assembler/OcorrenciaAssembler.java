package com.algaw.mercado.api.assembler;


import com.algaw.mercado.api.model.OcorrenciaModel;
import com.algaw.mercado.domain.model.Ocorrencia;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class OcorrenciaAssembler {

    private ModelMapper modelMapper;

    public OcorrenciaModel toModel(Ocorrencia ocorrencia) {
        return modelMapper.map(ocorrencia, OcorrenciaModel.class);
    }

    public List<OcorrenciaModel> toCollectionModel(List<Ocorrencia> ocorrencias) {
        return ocorrencias.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

}
