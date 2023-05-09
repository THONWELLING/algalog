package com.thonwelling.api.mapper;


import com.thonwelling.api.dtos.EntregaDto;
import com.thonwelling.api.models.Entrega;
import com.thonwelling.api.models.input.EntregaInput;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class EntregaMapper {

  private ModelMapper modelMapper;

  public EntregaDto toDTO(Entrega entrega) {
    return modelMapper.map(entrega, EntregaDto.class);
  }

  public List<EntregaDto> toListDTO(List<Entrega> listEntrega) {
    return listEntrega.stream()
        .map(this::toDTO)
        .collect(Collectors.toList());
  }

  public Entrega toEntity(@Valid EntregaInput entrega) {
    return modelMapper.map(entrega, Entrega.class);
  }
}
