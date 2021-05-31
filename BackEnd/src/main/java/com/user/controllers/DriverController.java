package com.user.controllers;


import com.user.dto.DriverDto;
import com.user.entity.DriverEntity;
import com.user.services.DriverServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class DriverController {
    private final DriverServices driverServices;
    private final ModelMapper map;


    @Autowired
    public DriverController(DriverServices driverServices, ModelMapper map){
        this.driverServices = driverServices;
        this.map = map;
    };

    @PostMapping(value = "/addDriver", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DriverDto> save(@RequestBody DriverDto driver){
        Optional<DriverEntity> response = driverServices.save(map.map(driver, DriverEntity.class));
        if(response.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(map.map(response.get(), DriverDto.class), HttpStatus.OK);
    }

    @GetMapping(value = "/driver/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DriverDto> getById(@PathVariable("id") Long id){
        Optional<DriverEntity> response = driverServices.findById(id);
        if(!response.isEmpty()){
            return new ResponseEntity<>(map.map(response.get(),DriverDto.class), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/drivers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DriverDto[]> getDrivers(){
        List<DriverEntity> response = driverServices.getAll();
        if(!response.isEmpty()){
            return new ResponseEntity<>(map.map(response,DriverDto[].class), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
