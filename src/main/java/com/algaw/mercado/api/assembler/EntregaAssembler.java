package com.algaw.mercado.api.assembler;

import com.algaw.mercado.api.model.EntregaModel;
import com.algaw.mercado.domain.model.Entrega;
import com.algaw.mercado.api.model.input.EntregaInput;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@AllArgsConstructor
@Component
public class EntregaAssembler {

    private ModelMapper modelMapper;

    public EntregaModel toModel(Entrega entrega) {
        return modelMapper.map(entrega, EntregaModel.class);
    }

    public List<EntregaModel> toCollectionModel (List<Entrega> entregas) {
        return entregas.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    public Entrega ToEntity(EntregaInput entregaInput) {
        return modelMapper.map(entregaInput, Entrega.class);
    }



}
