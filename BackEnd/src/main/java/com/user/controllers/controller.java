package com.user.controllers;

import com.user.dto.CarDto;
import com.user.dto.DistanceDto;
import com.user.dto.DriverDto;
import com.user.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class controller {


    @GetMapping("/holaMundo")
    public String holaMundo(){
        return "hola mundo";
    }

    @PostMapping(value = "/addItem", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addItem(@RequestBody UserDto item){
        return new ResponseEntity<>(item.getItem(), HttpStatus.OK);
    }

}
