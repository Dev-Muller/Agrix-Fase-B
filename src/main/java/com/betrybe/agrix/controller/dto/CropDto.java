package com.betrybe.agrix.controller.dto;

import com.betrybe.agrix.models.entity.Crop;
import com.betrybe.agrix.models.entity.Fertilizers;
import java.time.LocalDate;
import java.util.List;

/**
 * CropDto class.
 */
public record CropDto(
    Long id,
    String name,
    Double plantedArea,
    Long farmId,
    LocalDate plantedDate,
    LocalDate harvestDate,
    List<Fertilizers> fertilizers) {
  public CropDto toCropDto() {
    return new CropDto(id, name, plantedArea, farmId, plantedDate, harvestDate, fertilizers);
  }

  public static CropDto toDto(Crop crop) {
    return new CropDto(crop.getId(), crop.getName(), crop.getPlantedArea(),
        crop.getFarm().getId(), crop.getPlantedDate(), crop.getHarvestDate(),
        crop.getFertilizers());
  }
}
