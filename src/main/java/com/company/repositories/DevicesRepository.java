package com.company.repositories;

import com.company.domain.DeviceEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DevicesRepository extends CrudRepository<DeviceEntity, Long> {
        List<DeviceEntity> findBydevID(String devID);
}
