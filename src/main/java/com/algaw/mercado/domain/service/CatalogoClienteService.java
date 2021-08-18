package com.algaw.mercado.domain.service;

import com.algaw.mercado.domain.model.Cliente;
import com.algaw.mercado.domain.exception.NegocioException;
import com.algaw.mercado.domain.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class CatalogoClienteService {

    private ClienteRepository clienteRepository;

    //Método buscar com tratamento de cliente que pode ser inserido em Solitação de Entrega.
    public Cliente buscar(Long clienteId) {
        return clienteRepository.findById(clienteId)
                .orElseThrow(() -> new NegocioException("Cliente não encontrado"));
    }

    //orgspring Dentro da transação - erro (descartam ação)
    @Transactional
    public Cliente salvar(Cliente cliente) {
        boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
                .stream()
                .anyMatch(clienteExistente -> !clienteExistente.equals(cliente)); //verificar os clientes

        if (emailEmUso) {
            throw new NegocioException("Já existe um cliente cadastrado com esse Email");
        }

//        return (ClienteRepository) clienteRepository.save(cliente);
        return clienteRepository.save(cliente);
    }

    public void excluir(Long clienteId) {
        clienteRepository.deleteById(clienteId);
    }
}
