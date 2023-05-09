package com.thonwelling.api.services;


import com.thonwelling.api.models.Entrega;
import com.thonwelling.api.repository.EntregaRepository;
import com.thonwelling.api.utils.BuscarEntregaServiceUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class FinalizacaoEntregaService {

  BuscarEntregaServiceUtil buscarEntregaServiceUtil;
  EntregaRepository entregaRepository;

  public void finalizar(Long entregaId) {
    Entrega entrega = buscarEntregaServiceUtil.buscar(entregaId);

    entrega.finalizar();
    entregaRepository.save(entrega);

  }
}
