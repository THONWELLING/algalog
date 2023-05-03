package com.thonwelling.api.controllers;

import com.thonwelling.api.domain.models.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ClienteController {
  @GetMapping("/clientes")
  public List<Cliente> listar() {
    var cliente1 = new Cliente();
    cliente1.setId(1L);
    cliente1.setNome("Thonwelling");
    cliente1.setTelefone("11 12345-6789");
    cliente1.setEmail("admin@thonwelling.com");

    var cliente2 = new Cliente();
    cliente2.setId(2L);
    cliente2.setNome("Danithon");
    cliente2.setTelefone("11 12345-6789");
    cliente2.setEmail("admin@danithon.com");

    return Arrays.asList(cliente1, cliente2);
  }
}
