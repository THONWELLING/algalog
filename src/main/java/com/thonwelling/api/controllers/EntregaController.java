package com.thonwelling.api.controllers;

import com.thonwelling.api.domain.models.Entrega;
import com.thonwelling.api.services.SolicitaEntregaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping
public class EntregaController {

  SolicitaEntregaService solicitaEntregaService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Entrega solicitar (Entrega entrega) {

    return solicitaEntregaService.solicitar(entrega);
  }
}
