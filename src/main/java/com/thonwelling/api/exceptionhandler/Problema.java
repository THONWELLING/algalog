package com.thonwelling.api.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@AllArgsConstructor
public class Problema {

  private Integer status;
  private OffsetDateTime dataHora;
  private String titulo;

  private List<Campo> campos;

  public Problema() {
  }

  public Problema(Integer status, OffsetDateTime dataHora, String titulo) {
    this.status = status;
    this.dataHora = dataHora;
    this.titulo = titulo;
  }
}