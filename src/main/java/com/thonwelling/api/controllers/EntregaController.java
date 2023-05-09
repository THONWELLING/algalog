package com.thonwelling.api.controllers;

import com.thonwelling.api.dtos.EntregaDto;
import com.thonwelling.api.mapper.EntregaMapper;
import com.thonwelling.api.models.Entrega;
import com.thonwelling.api.models.input.EntregaInput;
import com.thonwelling.api.repository.EntregaRepository;
import com.thonwelling.api.services.FinalizacaoEntregaService;
import com.thonwelling.api.services.SolicitacaoEntregaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {

  EntregaRepository entregaRepository;
  SolicitacaoEntregaService solicitacaoEntregaService;
  FinalizacaoEntregaService finalizacaoEntregaService;
  EntregaMapper entregaMapper;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public EntregaDto solicitar (@Valid @RequestBody EntregaInput entregaInput){
      Entrega entregaSolicitada = solicitacaoEntregaService.solicitar(entregaMapper.toEntity(entregaInput));
      return entregaMapper.toDTO(entregaSolicitada);
    }

    @GetMapping
    public List<EntregaDto> listar () {
      List<Entrega> listEntrega = entregaRepository.findAll();

      return entregaMapper.toListDTO(listEntrega);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<EntregaDto> obterPorId (@PathVariable Long id){
      return entregaRepository.findById(id)
          .map(entrega -> ResponseEntity.ok(entregaMapper.toDTO(entrega)))
          .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(path = "/{id}/finalizacao")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void finalizar (@PathVariable Long id){
      finalizacaoEntregaService.finalizar(id);
    }

}
