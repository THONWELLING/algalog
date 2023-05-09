package com.thonwelling.api.models.input;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class EntregaInput {
  @Valid
  @NotNull
  private ClienteIdInput cliente;

  @Valid
  @NotNull
  private DestinatarioInput destinatario;

  @NotNull
  private BigDecimal taxa;
}
