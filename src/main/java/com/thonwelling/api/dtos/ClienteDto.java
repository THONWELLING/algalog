package com.thonwelling.api.dtos;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter

public class ClienteDto {
  private Long id;
  private String nome;
  private String telefone;
}
