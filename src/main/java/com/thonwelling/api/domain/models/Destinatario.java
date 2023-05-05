package com.thonwelling.api.domain.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Embeddable
@Table(name = "destinatario")
public class Destinatario  {



  @Column(name="destinatario_nome")
  private String nome;

  @Column(name="destinatario_logradouro")
  private String logradouro;

  @Column(name="destinatario_numero")
  private String numero;

  @Column(name="destinatario_complemento")
  private String complemento;

  @Column(name="destinatario_bairro")
  private String bairro;
}
