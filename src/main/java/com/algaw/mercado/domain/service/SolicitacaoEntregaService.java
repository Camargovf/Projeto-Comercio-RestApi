package com.algaw.mercado.domain.service;

import com.algaw.mercado.domain.model.Cliente;
import com.algaw.mercado.domain.model.Entrega;
import com.algaw.mercado.domain.model.StatusEntrega;
import com.algaw.mercado.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;


@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {

    private CatalogoClienteService catalogoClienteService;
    private EntregaRepository entregaRepository;

    @Transactional
    //Método solicitar que puxa método de tratamento buscar do Catalogo.
    public Entrega solicitar(Entrega entrega){
       Cliente cliente = catalogoClienteService.buscar(entrega.getCliente().getId());

        entrega.setCliente(cliente);
        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataPedido(OffsetDateTime.now());
        return entregaRepository.save(entrega);


    }
}
