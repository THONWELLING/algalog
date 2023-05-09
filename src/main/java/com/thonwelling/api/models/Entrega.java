package com.thonwelling.api.models;

import com.thonwelling.api.exception.NegocioException;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

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
  private OffsetDateTime dataPedido;

  private OffsetDateTime dataFinalizacao;

  @OneToMany(mappedBy = "entrega", cascade = CascadeType.ALL)
  private List<Ocorrencia> listOcorrencia = new ArrayList<Ocorrencia>();

  public Ocorrencia adicionarOcorrencia(String descricao) {
    Ocorrencia ocorrencia = new Ocorrencia();
    ocorrencia.setDescricao(descricao);
    ocorrencia.setEntrega(this);
    ocorrencia.setDataRegistro(OffsetDateTime.now());

    this.getListOcorrencia().add(ocorrencia);

    return ocorrencia;

  }
  public void finalizar() {
    if(naoPodeSerFinalizada()) {
      throw new NegocioException("Entrega não pode ser finalizada.");
    }

    this.setStatus(StatusEntrega.FINALIZADA);
    this.setDataFinalizacao(OffsetDateTime.now());
  }

  private boolean podeSerFinalizada() {
    return StatusEntrega.PENDENTE.equals(this.getStatus());
  }

  private boolean naoPodeSerFinalizada() {
    return !podeSerFinalizada();
  }

}
