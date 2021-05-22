package com.tony.logistica.api.mappers;

import com.tony.logistica.api.model.OccurrenceDTO;
import com.tony.logistica.domain.model.Occurrence;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class OccurrenceMapper {

    private ModelMapper modelMapper;

    public OccurrenceDTO toDTO(Occurrence occurrence) {
        return modelMapper.map(occurrence, OccurrenceDTO.class);
    }

    public List<OccurrenceDTO> toCollectionOccurrencesDTO(List<Occurrence> occurrences) {
        return occurrences.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
