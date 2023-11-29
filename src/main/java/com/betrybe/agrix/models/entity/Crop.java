package com.betrybe.agrix.models.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Crop entity.
 */
@Entity
@Table(name = "crops")
@Data
public class Crop {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;

  @Column(name = "planted_area")
  private Double plantedArea;

  @ManyToOne
  @JoinColumn(name = "farm_id")
  private Farm farm;

  @Column(name = "planted_date")
  private LocalDate plantedDate;

  @Column (name = "harvest_date")
  private LocalDate harvestDate;

  /**
   * Constructor vazio.
   */
  public Crop() {

  }

  /**
   * Constructor.
   */
  public Crop(Long id, String name, Double plantedArea, Farm farm,
      LocalDate plantedDate, LocalDate harvestDate) {
    this.id = id;
    this.name = name;
    this.plantedArea = plantedArea;
    this.farm = farm;
    this.plantedDate = plantedDate;
    this.harvestDate = harvestDate;
  }
}
