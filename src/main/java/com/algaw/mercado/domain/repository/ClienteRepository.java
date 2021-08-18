package com.algaw.mercado.domain.repository;

import com.algaw.mercado.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository //gerencia entidade e injeção de dependências.
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findByNome(String nome); //pesquisa por nome.
    List<Cliente> findByNomeContaining(String nome); //pesquisa por nome. //like do SQL
    Optional<Cliente> findByEmail(String email);
}
