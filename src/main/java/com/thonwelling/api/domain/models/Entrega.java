package com.thonwelling.api.domain.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Setter
@Table(name = "entregas")
public class Entrega implements Serializable {

  @EqualsAndHashCode.Include
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  private Cliente cliente;

  @Embedded
  private Destinatario destinatario;
  private BigDecimal taxa;

  @Enumerated(EnumType.STRING)
  private StatusEntrega status;
  private LocalDateTime dataPedido;
  private LocalDateTime dataFinalizacao;

}
