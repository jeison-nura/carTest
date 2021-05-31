package com.user.services.impl;

import com.user.dto.CarDto;
import com.user.entity.CarEntity;
import com.user.repository.ICarRepository;
import com.user.services.CarServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarServices {
    private final ICarRepository iCarRepository;
    private final ModelMapper mapper;

    @Autowired
    public CarServiceImpl(ICarRepository iCarRepository, ModelMapper mapper) {
        this.iCarRepository = iCarRepository;
        this.mapper = mapper;
    }

    @Override
    public Optional<CarEntity> save(CarEntity carEntity) {
        CarEntity response = iCarRepository.save(carEntity);
        return Optional.of(response);
    }

    @Override
    public Optional<CarEntity> findById(Long idCar) {
        return iCarRepository.findById(idCar);
    }

    @Override
    public List<CarEntity> getAll() {
        return iCarRepository.findAll();
    }

    @Override
    public Optional<CarEntity> updateCar(CarDto carDto) {
        Optional<CarEntity> entity = iCarRepository.findById(carDto.getId());
        if(entity.isPresent()){
            CarEntity car = entity.get();
            car = mapper.map(carDto, CarEntity.class);
            iCarRepository.save(car);
            return Optional.of(car);
        }
        return Optional.empty();
    }

    @Override
    public Optional<CarEntity> deleteCar(Long idCar) {
        iCarRepository.deleteById(idCar);
        return Optional.empty();
    }
}
