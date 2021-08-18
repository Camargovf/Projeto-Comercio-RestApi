package com.algaw.mercado.domain.service;


import com.algaw.mercado.domain.model.Entrega;
import com.algaw.mercado.domain.model.Ocorrencia;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class RegistroOcorrenciaService {


    private BuscaEntregaService buscaEntregaService;

    @Transactional
    public Ocorrencia registrar(Long entregaId, String descricao) {
        Entrega entrega = buscaEntregaService.buscar(entregaId);



      return  entrega.adicionarOcorrencia(descricao);
    }


}
