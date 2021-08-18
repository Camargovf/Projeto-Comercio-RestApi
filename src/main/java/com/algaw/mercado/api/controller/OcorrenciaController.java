package com.algaw.mercado.api.controller;



import com.algaw.mercado.api.assembler.OcorrenciaAssembler;
import com.algaw.mercado.api.model.OcorrenciaModel;
import com.algaw.mercado.api.model.input.OcorrenciaInput;
import com.algaw.mercado.domain.model.Entrega;
import com.algaw.mercado.domain.model.Ocorrencia;
import com.algaw.mercado.domain.service.BuscaEntregaService;
import com.algaw.mercado.domain.service.RegistroOcorrenciaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
@Api(value="API REST Ocorrencias")
@CrossOrigin(origins="*")
public class OcorrenciaController {

    private BuscaEntregaService buscaEntregaService;
    private RegistroOcorrenciaService registroOcorrenciaService;
    private OcorrenciaAssembler ocorrenciaAssembler;

    @PostMapping
    @ApiOperation(value="Cria uma ocorrência")
    @ResponseStatus(HttpStatus.CREATED)
    public OcorrenciaModel registrar(@PathVariable Long entregaId,
                                     @Valid @RequestBody OcorrenciaInput ocorrenciaInput) {

        Ocorrencia ocorrenciaRegistrada = registroOcorrenciaService
                .registrar(entregaId, ocorrenciaInput.getDescricao());

        return ocorrenciaAssembler.toModel(ocorrenciaRegistrada);

    }

    @GetMapping
    @ApiOperation(value="Lista uma ocorrência")
    public List<OcorrenciaModel> listar(@PathVariable Long entregaId) {
        Entrega entrega = buscaEntregaService.buscar(entregaId);

        return ocorrenciaAssembler.toCollectionModel(entrega.getOcorrencias());
    }

}
