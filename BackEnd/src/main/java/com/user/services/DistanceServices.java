package com.user.services;

import com.user.dto.DistanceDto;
import com.user.entity.DistanceEntity;

import java.util.List;
import java.util.Optional;

public interface DistanceServices {
    Optional<DistanceEntity>save(DistanceEntity distanceEntity);
    Optional<DistanceEntity>updateDistance(DistanceDto distanceDto);
    List<DistanceEntity>getAll();
}
