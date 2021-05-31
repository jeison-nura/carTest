package com.user.services;

import com.user.entity.DriverEntity;

import java.util.List;
import java.util.Optional;

public interface DriverServices {
    Optional<DriverEntity> findById(long idDriver);
    Optional<DriverEntity> save(DriverEntity driverEntity);
    List<DriverEntity> getAll();
}
