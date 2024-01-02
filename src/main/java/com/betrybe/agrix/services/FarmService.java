package com.betrybe.agrix.services;

import com.betrybe.agrix.exception.FarmNotFoundException;
import com.betrybe.agrix.models.entities.Crop;
import com.betrybe.agrix.models.entities.Farm;
import com.betrybe.agrix.models.repositories.CropRepository;
import com.betrybe.agrix.models.repositories.FarmRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 * The type Farm service.
 */
@Service
public class FarmService {
  private final FarmRepository farmRepository;
  private final CropRepository cropRepository;

  public FarmService(FarmRepository farmRepository, CropRepository cropRepository) {
    this.farmRepository = farmRepository;
    this.cropRepository = cropRepository;
  }

  public Farm createFarm(Farm farm) {
    return farmRepository.save(farm);
  }

  public List<Farm> getAllFarms() {
    return farmRepository.findAll();
  }

  /**
   * Gets farm by id.
   *
   * @param farmId the farm id
   * @return the farm by id
   */
  public Farm getFarmById(Long farmId) {
    Optional<Farm> farmOptional = farmRepository.findById(farmId);
    if (farmOptional.isEmpty()) {
      throw new FarmNotFoundException();
    }
    return farmOptional.get();
  }

  /**
   * Insert crop crop.
   *
   * @param farmId the farm id
   * @param crop   the crop
   * @return the crop
   */
  public Crop insertCrop(Long farmId, Crop crop) {
    Optional<Farm> farmOptional = farmRepository.findById(farmId);
    if (farmOptional.isEmpty()) {
      throw new FarmNotFoundException();
    }

    Farm farm = farmOptional.get();
    crop.setFarm(farm);

    return cropRepository.save(crop);
  }

  /**
   * Gets crops by farm id.
   *
   * @param farmId the farm id
   * @return the crops by farm id
   */
  public List<Crop> getCropsByFarmId(Long farmId) {
    Optional<Farm> farmOptional = farmRepository.findById(farmId);
    if (farmOptional.isEmpty()) {
      throw new FarmNotFoundException();
    }

    Farm farm = farmOptional.get();
    return farm.getCrops();
  }
}
