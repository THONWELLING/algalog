package com.thonwelling.api.domain.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@EqualsAndHashCode
@Setter
@Table(name = "cliente")
public class Cliente {
  private Long id;
  private String nome;
  private String email;
  private String telefone;
}
