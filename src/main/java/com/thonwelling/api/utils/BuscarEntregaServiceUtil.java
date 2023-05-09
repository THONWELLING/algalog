package com.thonwelling.api.utils;

import com.thonwelling.api.exception.EntidadeNaoEncontradaException;
import com.thonwelling.api.models.Entrega;
import com.thonwelling.api.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BuscarEntregaServiceUtil {
  private EntregaRepository entregaRepository;

  public Entrega buscar(Long id) {
    return entregaRepository.findById(id)
        .orElseThrow( () -> new EntidadeNaoEncontradaException("Entrega não encontrada."));
  }
}
