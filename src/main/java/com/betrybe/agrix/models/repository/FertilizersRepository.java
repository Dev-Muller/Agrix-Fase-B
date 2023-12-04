package com.betrybe.agrix.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betrybe.agrix.models.entity.Fertilizers;

/**
 * FertilizersRepository interface.
 */
public interface FertilizersRepository extends JpaRepository<Fertilizers, Long> {
    
}
