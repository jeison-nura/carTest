package com.user.services.impl;

import com.user.dto.DistanceDto;
import com.user.entity.CarEntity;
import com.user.entity.DistanceEntity;
import com.user.repository.IDistanceRepository;
import com.user.services.DistanceServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DistanceImpl implements DistanceServices {
    private final ModelMapper mapper;
    private final IDistanceRepository iDistanceRepository;

    @Autowired
    public DistanceImpl(IDistanceRepository iDistanceRepository, ModelMapper mapper) {
        this.iDistanceRepository = iDistanceRepository;
        this.mapper = mapper;
    }

    @Override
    public Optional<DistanceEntity> save(DistanceEntity distanceEntity) {
        DistanceEntity response = iDistanceRepository.save(distanceEntity);
        return Optional.of(response);
    }

    @Override
    public Optional<DistanceEntity> updateDistance(DistanceDto distanceDto) {
        Optional<DistanceEntity> entity = iDistanceRepository.findById(distanceDto.getId());
        if(entity.isPresent()) {
            DistanceEntity distance = entity.get();
            distance = mapper.map(distanceDto, DistanceEntity.class);
            iDistanceRepository.save(distance);
            return Optional.of(distance);
        }
        return Optional.empty();
    }

    @Override
    public List<DistanceEntity> getAll() {
        return iDistanceRepository.findAll();
    }
}
