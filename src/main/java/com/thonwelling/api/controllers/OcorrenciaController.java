package com.thonwelling.api.controllers;


import com.thonwelling.api.dtos.OcorrenciaDto;
import com.thonwelling.api.mapper.OcorrenciaMapper;
import com.thonwelling.api.models.Entrega;
import com.thonwelling.api.models.Ocorrencia;
import com.thonwelling.api.models.input.OcorrenciaInput;
import com.thonwelling.api.services.OcorrenciaService;
import com.thonwelling.api.utils.BuscarEntregaServiceUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {
  private BuscarEntregaServiceUtil buscarEntregaServiceUtil;

  private OcorrenciaService ocorrenciaService;

  private OcorrenciaMapper ocorrenciaMapper;

  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  public OcorrenciaDto registrar (
      @PathVariable Long entregaId,
      @Valid @RequestBody OcorrenciaInput ocorrenciaInput
  ) {

    Entrega entrega = buscarEntregaServiceUtil.buscar(entregaId);

    Ocorrencia ocorrenciaRegistrada = ocorrenciaService.registrar(entregaId, ocorrenciaInput.getDescricao(), entrega);

    return ocorrenciaMapper.toDTO(ocorrenciaRegistrada);
  }

  @GetMapping()
  public List<OcorrenciaDto> listar (@PathVariable Long entregaId) {

    Entrega entrega = buscarEntregaServiceUtil.buscar(entregaId);
    List<Ocorrencia> listOcorrencia = entrega.getListOcorrencia();
    return ocorrenciaMapper.toListDTO(listOcorrencia);
  }
}
