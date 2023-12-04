package com.betrybe.agrix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betrybe.agrix.controller.dto.FertilizersDto;
import com.betrybe.agrix.models.entity.Fertilizers;
import com.betrybe.agrix.service.FertilizersService;

/**
 * FertilizersController class.
 */
@RestController
@RequestMapping("/fertilizers")
public class FertilizersController {
    
    @Autowired
    private final FertilizersService fertilizersService;

    /**
     * FertilizersController constructor.
     */
    public FertilizersController(FertilizersService fertilizersService) {
        this.fertilizersService = fertilizersService;
    }

    /**
     * Create a fertilizer.
     */
    @PostMapping
    public ResponseEntity<FertilizersDto> createFertilizers(@RequestBody FertilizersDto fertilizersDto) {
        Fertilizers newFertilizers = fertilizersService.createFertilizers(fertilizersDto.toEntity());
        FertilizersDto newFertilizersDto = FertilizersDto.toDto(newFertilizers);
        return new ResponseEntity<>(newFertilizersDto, HttpStatus.CREATED);
    }
}
