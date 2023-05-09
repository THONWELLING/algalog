package com.thonwelling.api.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;


@Getter
@Setter
public class OcorrenciaDto {
  private Long id;
  private String descricao;
  private OffsetDateTime dataRegistro;
}
