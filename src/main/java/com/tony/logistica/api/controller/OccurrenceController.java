package com.tony.logistica.api.controller;

import com.tony.logistica.api.mappers.OccurrenceMapper;
import com.tony.logistica.api.model.OccurrenceDTO;
import com.tony.logistica.api.model.input.OccurrenceInputDTO;
import com.tony.logistica.domain.model.Delivery;
import com.tony.logistica.domain.model.Occurrence;
import com.tony.logistica.domain.service.FindDeliveryService;
import com.tony.logistica.domain.service.OccurrenceRegistryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/deliveries/{id}/occurrences")
public class OccurrenceController {

    private final OccurrenceRegistryService occurrenceRegistryService;
    private final OccurrenceMapper occurrenceMapper;
    private final FindDeliveryService findDeliveryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private OccurrenceDTO saveOccurrence(@PathVariable Long id, @Valid @RequestBody OccurrenceInputDTO inputDTO) {

        Occurrence occurrence = occurrenceRegistryService.registryOccurrence(id, inputDTO.getDescription());
        return occurrenceMapper.toDTO(occurrence);
    }

    @GetMapping
    private List<OccurrenceDTO> findAllOccurrences(@PathVariable Long id) {
        Delivery delivery = findDeliveryService.findDelivery(id);

        return occurrenceMapper.toCollectionOccurrencesDTO(delivery.getOccurrences());
    }


}
