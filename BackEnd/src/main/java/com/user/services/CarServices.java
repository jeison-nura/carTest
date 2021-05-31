package com.user.services;

import com.user.dto.CarDto;
import com.user.entity.CarEntity;

import java.util.List;
import java.util.Optional;

public interface CarServices {
    Optional<CarEntity>save(CarEntity carEntity);
    Optional<CarEntity>findById(Long idCar);
    List<CarEntity>getAll();
    Optional<CarEntity>updateCar(CarDto carDto);
    Optional<CarEntity>deleteCar(Long idCar);
}
