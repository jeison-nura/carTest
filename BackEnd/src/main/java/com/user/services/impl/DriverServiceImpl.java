package com.user.services.impl;

import com.user.entity.DriverEntity;
import com.user.repository.IDriverRepository;
import com.user.services.DriverServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverServiceImpl implements DriverServices {
    private final IDriverRepository iDriverRepository;

    @Autowired
    public DriverServiceImpl(IDriverRepository iDriverRepository) {
        this.iDriverRepository = iDriverRepository;
    }

    @Override
    public Optional<DriverEntity> findById(long idDriver) {
        return iDriverRepository.findById(idDriver);
    }

    @Override
    public Optional<DriverEntity> save(DriverEntity driverEntity) {
        DriverEntity response = iDriverRepository.save(driverEntity);
        return Optional.of(response);
    }

    @Override
    public List<DriverEntity> getAll() {
        return iDriverRepository.findAll();
    }

}
