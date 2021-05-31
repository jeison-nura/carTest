package com.user.controllers;

import com.user.dto.CarDto;
import com.user.entity.CarEntity;
import com.user.services.CarServices;
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
public class CarController {
    private final CarServices carServices;
    private final ModelMapper map;

    @Autowired
    public CarController(CarServices carServices,ModelMapper map){
        this.carServices = carServices;
        this.map = map;
    };


    @PostMapping(value = "/addCar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CarDto> save(@RequestBody CarDto car){
        Optional<CarEntity> response = carServices.save(map.map(car, CarEntity.class));
        if(response.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(map.map(response.get(), CarDto.class), HttpStatus.OK);
    }

    @GetMapping(value = "/car/{idCar}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CarDto> getById(@PathVariable("idCar") long idCar){
        Optional <CarEntity> response = carServices.findById(idCar);
        if(!response.isEmpty()){
            return new ResponseEntity<>(map.map(response.get(), CarDto.class), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/cars", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CarDto[]> getById(){
        List<CarEntity> response = carServices.getAll();
        if(!response.isEmpty()){
            return new ResponseEntity<>(map.map(response, CarDto[].class), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/updateCars", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CarDto>updateCar(@RequestBody CarDto carDto){
        Optional<CarEntity> response = carServices.updateCar(carDto);
        if(!response.isEmpty()){
            return new ResponseEntity<>(map.map(response.get(), CarDto.class), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/deleteCar/{idCar}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CarDto>DeleteCar(@PathVariable("idCar") Long idCar){
        Optional<CarEntity> response = carServices.deleteCar(idCar);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
