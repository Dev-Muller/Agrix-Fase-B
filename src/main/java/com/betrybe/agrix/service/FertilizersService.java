package com.betrybe.agrix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betrybe.agrix.models.entity.Fertilizers;
import com.betrybe.agrix.models.repository.FertilizersRepository;

/**
 * FertilizersService class.
 */
@Service
public class FertilizersService {
    
    @Autowired
    FertilizersRepository fertilizersRepository;

    /**
     * FertilizersService constructor.
     */
    public FertilizersService(FertilizersRepository fertilizersRepository) {
        this.fertilizersRepository = fertilizersRepository;
    }

    public Fertilizers createFertilizers(Fertilizers fertilizers) {
        return fertilizersRepository.save(fertilizers);
    }
}
