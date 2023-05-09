package com.thonwelling.api.models.input;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class OcorrenciaInput {
  @NotBlank
  private String descricao;
}
