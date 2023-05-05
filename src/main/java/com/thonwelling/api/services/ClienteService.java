package com.thonwelling.api.services;

import com.thonwelling.api.domain.models.Cliente;
import com.thonwelling.api.exception.NegocioException;
import com.thonwelling.api.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ClienteService {

     ClienteRepository clienteRepository;

    public Cliente buscarCliente(Long clienteId){
      return clienteRepository.findById(clienteId)
          .orElseThrow(() -> new NegocioException("Cliente Não Encontrado!!!"));
    }
    @Transactional
    public Cliente salvar(Cliente cliente){
      boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
          .stream()
          .anyMatch(clienteExistente -> !clienteExistente.equals(cliente));

      if(emailEmUso) {
        throw new NegocioException("Já existe um cliente cadastrado com este e-mail!");
      }
      return clienteRepository.save(cliente);
    }

    @Transactional
    public void excluir(Long clientId){
      clienteRepository.deleteById(clientId);
    }

    @Transactional
    public List<Cliente> buscarTodosOsClientes(){
      return clienteRepository.findAll();
    }

    @Transactional
    public Optional<Cliente> buscarUmClientePorId(Long clienteId){
      return clienteRepository.findById(clienteId);
    }
}


