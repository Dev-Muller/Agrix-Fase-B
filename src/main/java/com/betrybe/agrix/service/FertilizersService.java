package com.betrybe.agrix.service;

import com.betrybe.agrix.models.entity.Fertilizers;
import com.betrybe.agrix.models.repository.FertilizersRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

  /**
   * Create a fertilizer.
   */
  public Fertilizers createFertilizers(Fertilizers fertilizers) {
    return fertilizersRepository.save(fertilizers);
  }

  /**
   * Get all fertilizer.
   */
  public List<Fertilizers> getAllFertilizers() {
    return fertilizersRepository.findAll();
  }
}
