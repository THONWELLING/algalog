package com.thonwelling.api.services;

import com.thonwelling.api.domain.models.Cliente;
import com.thonwelling.api.domain.models.Entrega;
import com.thonwelling.api.domain.models.StatusEntrega;
import com.thonwelling.api.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class SolicitaEntregaService {
  EntregaRepository entregaRepository;
  ClienteService clienteService;
  @Transactional
  public Entrega solicitar (Entrega entrega) {
    Cliente cliente = clienteService.buscarCliente(entrega.getCliente().getId());

    entrega.setCliente(cliente);
    entrega.setStatus(StatusEntrega.PENDENTE);
    entrega.setDataPedido(LocalDateTime.now());
    return entregaRepository.save(entrega);
  }
}
