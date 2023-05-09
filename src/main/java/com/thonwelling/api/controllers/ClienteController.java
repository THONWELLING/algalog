package com.thonwelling.api.controllers;

import com.thonwelling.api.models.Cliente;
import com.thonwelling.api.repository.ClienteRepository;
import com.thonwelling.api.services.ClienteService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClienteController {
  private ClienteRepository clienteRepository;
  private ClienteService clienteService;

  @GetMapping
  public List<Cliente> listar(){
    return clienteService.buscarTodosOsClientes();
    // return clienteRepository.findByNomeContaining("o");
  }

  @GetMapping("/{clienteId}")
  public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId){
    return clienteService.buscarUmClientePorId(clienteId)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Cliente adicionar(@Valid @RequestBody Cliente cliente){
    return clienteService.salvar(cliente);
  }

  @PutMapping("/{clienteId}")
  public ResponseEntity<Cliente> atualizar(@Valid @PathVariable Long clienteId, @RequestBody Cliente cliente){

    if(!clienteRepository.existsById(clienteId)){
      return ResponseEntity.notFound().build();
    }
    cliente.setId(clienteId);
    cliente = clienteService.salvar(cliente);
    return ResponseEntity.ok(cliente);
  }

  @DeleteMapping("/{clienteId}")
  public ResponseEntity<Void> remover(@PathVariable Long clienteId){

    if(!clienteRepository.existsById(clienteId)){
      return ResponseEntity.notFound().build();
    }
    clienteService.excluir(clienteId);
    return ResponseEntity.noContent().build();
  }
}
