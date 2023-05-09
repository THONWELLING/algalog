package com.thonwelling.api.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.thonwelling.api.models.Cliente;
import com.thonwelling.api.models.StatusEntrega;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EntregaDto {

  private Long id;
  private Cliente cliente;
  private DestinatarioDto destinatario;
  private BigDecimal taxa;
  private StatusEntrega status;
  private LocalDateTime dataPedido;
  private LocalDateTime dataFinalizacao;

}
