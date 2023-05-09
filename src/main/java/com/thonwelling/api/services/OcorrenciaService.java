package com.thonwelling.api.services;


import com.thonwelling.api.models.Entrega;
import com.thonwelling.api.models.Ocorrencia;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OcorrenciaService {
  @Transactional
  public Ocorrencia registrar(Long entregaId, String descricao, Entrega entrega) {
    return entrega.adicionarOcorrencia(descricao);
  }
}
