package com.betrybe.agrix.models.repositories;

import com.betrybe.agrix.models.entities.Farm;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Farm repository.
 */
public interface FarmRepository extends JpaRepository<Farm, Long> {

}
