package com.thonwelling.api.mapper;


import com.thonwelling.api.dtos.OcorrenciaDto;
import com.thonwelling.api.models.Ocorrencia;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class OcorrenciaMapper {
  private ModelMapper modelMapper;

  public OcorrenciaDto toDTO(Ocorrencia ocorrencica) {
    return modelMapper.map(ocorrencica, OcorrenciaDto.class);
  }

  public List<OcorrenciaDto> toListDTO(List<Ocorrencia> listOcorrencia) {
    return listOcorrencia.stream()
        .map(this::toDTO)
        .collect(Collectors.toList());
  }
}
