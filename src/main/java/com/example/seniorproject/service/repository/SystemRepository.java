package com.example.seniorproject.service.repository;

import com.example.seniorproject.service.model.SystemInfEntity;
import org.springframework.data.repository.CrudRepository;

public interface SystemRepository extends CrudRepository<SystemInfEntity, Long> {
    SystemInfEntity findByGreenHouseId (String greenHouseId);
}
