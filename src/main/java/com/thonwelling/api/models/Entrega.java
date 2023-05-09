package com.thonwelling.api.models;

import com.thonwelling.api.exception.NegocioException;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

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

  public void finalizar() {
    if(naoPodeSerFinalizada()) {
      throw new NegocioException("Entrega não pode ser finalizada.");
    }

    this.setStatus(StatusEntrega.FINALIZADA);
    this.setDataFinalizacao(OffsetDateTime.now().toLocalDateTime());
  }

  private boolean podeSerFinalizada() {
    return StatusEntrega.PENDENTE.equals(this.getStatus());
  }

  private boolean naoPodeSerFinalizada() {
    return !podeSerFinalizada();
  }

}
