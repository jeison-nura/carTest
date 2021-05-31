package com.user.controllers;


import com.user.dto.DistanceDto;
import com.user.entity.DistanceEntity;
import com.user.services.DistanceServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class DistanceController {
    private final DistanceServices distanceServices;
    private final ModelMapper map;


    @Autowired
    public DistanceController(DistanceServices distanceServices, ModelMapper map) {
        this.distanceServices = distanceServices;
        this.map = map;
    }

    @PostMapping(value = "/addDistance",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DistanceDto> save(@RequestBody DistanceDto distanceDto){
        Optional<DistanceEntity> response = distanceServices.save(map.map(distanceDto, DistanceEntity.class));
        if(response.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(map.map(response.get(), DistanceDto.class), HttpStatus.OK);
    }

    @PutMapping(value = "/updateDistance",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DistanceDto> updateDistance(@RequestBody DistanceDto distanceDto){
        Optional<DistanceEntity> response = distanceServices.updateDistance(distanceDto);
        if(response.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(map.map(response.get(), DistanceDto.class), HttpStatus.OK);
    }

    @GetMapping(value = "/distance", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DistanceDto[]> getDistances(){
        List<DistanceEntity> response = distanceServices.getAll();
        if(response.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(map.map(response, DistanceDto[].class), HttpStatus.OK);
    }
}
