package com.thonwelling.api.services;

import com.thonwelling.api.models.Cliente;
import com.thonwelling.api.models.Entrega;
import com.thonwelling.api.models.StatusEntrega;
import com.thonwelling.api.repository.EntregaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;

public class SolicitacaoEntregaService {

  private ClienteService clienteService;
  private EntregaRepository entregaRepository;

  @Transactional
  public Entrega solicitar(Entrega entrega) {

    Cliente cliente = clienteService.buscarCliente(entrega.getCliente().getId());

    entrega.setCliente(cliente);
    entrega.setStatus(StatusEntrega.PENDENTE);
    entrega.setDataPedido(OffsetDateTime.now());

    return entregaRepository.save(entrega);
  }
}
