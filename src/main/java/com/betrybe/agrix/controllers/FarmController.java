package com.betrybe.agrix.controllers;

import com.betrybe.agrix.controllers.dto.CropDto;
import com.betrybe.agrix.controllers.dto.FarmDto;
import com.betrybe.agrix.models.entities.Crop;
import com.betrybe.agrix.models.entities.Farm;
import com.betrybe.agrix.services.FarmService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Farm controller.
 */
@RestController
@RequestMapping("/farms")
public class FarmController {
  private final FarmService farmService;

  @Autowired
  public FarmController(FarmService farmService) {
    this.farmService = farmService;
  }

  @PostMapping
  public ResponseEntity<FarmDto> createFarm(@RequestBody FarmDto farmDto) {
    Farm newFarm = farmService.createFarm(farmDto.toFarm());
    return ResponseEntity.status(HttpStatus.CREATED).body(FarmDto.toDto(newFarm));
  }

  /**
   * Gets all farms.
   *
   * @return the all farms
   */
  @GetMapping
  public ResponseEntity<List<FarmDto>> getAllFarms() {
    List<Farm> allFarms = farmService.getAllFarms();
    List<FarmDto> allFarmsDto = allFarms.stream()
        .map(farm -> FarmDto.toDto(farm)).toList();
    return ResponseEntity.ok(allFarmsDto);
  }

  @GetMapping("/{farmId}")
  public ResponseEntity<Farm> getFarmById(@PathVariable Long farmId) {
    Farm farm = farmService.getFarmById(farmId);
    return ResponseEntity.ok(farm);
  }

  @PostMapping("/{farmId}/crops")
  public ResponseEntity<CropDto> insertCrop(@PathVariable Long farmId,
      @RequestBody CropDto cropDto) {
    Crop newCrop = farmService.insertCrop(farmId, cropDto.toCrop());
    return ResponseEntity.status(HttpStatus.CREATED).body(CropDto.toDto(newCrop));
  }

  /**
   * Gets crops by farm id.
   *
   * @param farmId the farm id
   * @return the crops by farm id
   */
  @GetMapping("/{farmId}/crops")
  public ResponseEntity<List<CropDto>> getCropsByFarmId(@PathVariable Long farmId) {
    List<Crop> crops = farmService.getCropsByFarmId(farmId);
    List<CropDto> cropsDto = crops.stream()
        .map(crop -> CropDto.toDto(crop))
        .toList();
    return ResponseEntity.ok(cropsDto);
  }
}
