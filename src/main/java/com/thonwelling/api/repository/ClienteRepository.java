package com.thonwelling.api.repository;

import com.thonwelling.api.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
  List<Cliente> findByNome(String nome);
  List<Cliente> findByNomeContaining(String nome); //usa o like do SQL
  Optional<Cliente> findByEmail(String email);
}
