package com.algaw.mercado.api.controller;


import com.algaw.mercado.api.assembler.EntregaAssembler;
import com.algaw.mercado.api.model.EntregaModel;
import com.algaw.mercado.api.model.input.EntregaInput;
import com.algaw.mercado.domain.model.Entrega;
import com.algaw.mercado.domain.repository.EntregaRepository;
import com.algaw.mercado.domain.service.FinalizacaoEntregaService;
import com.algaw.mercado.domain.service.SolicitacaoEntregaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
@Api(value="API REST Entregas")
@CrossOrigin(origins="*")
public class EntregaController {

    private EntregaRepository entregaRepository;
    private SolicitacaoEntregaService solicitacaoEntregaService;
    private FinalizacaoEntregaService finalizacaoEntregaService;
    private EntregaAssembler entregaAssembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value="Lista todos as entregas")
    public EntregaModel solicitar(@Valid @RequestBody EntregaInput entregaInput) {
        Entrega novaEntrega = entregaAssembler.ToEntity(entregaInput);
        Entrega entregaSolicitada = solicitacaoEntregaService.solicitar(novaEntrega);

        return entregaAssembler.toModel(entregaSolicitada);
    }

    @PutMapping("/{entregaId}/finalizacao")
    @ApiOperation(value="Atualiza uma entrega")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void finalizar(@PathVariable Long entregaId) {
        finalizacaoEntregaService.finalizar(entregaId);
    }

    @GetMapping
    public List<EntregaModel> listar() {
        return entregaAssembler.toCollectionModel(entregaRepository.findAll());
    }

    @GetMapping("/{entregaId}")
    @ApiOperation(value="Busca uma entrega por Id")
    public ResponseEntity<EntregaModel> buscar(@PathVariable Long entregaId) {
        return entregaRepository.findById(entregaId)
                .map(entrega -> ResponseEntity.ok(entregaAssembler.toModel(entrega)))
                .orElse(ResponseEntity.notFound().build());
    }

}
