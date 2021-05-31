package com.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarDto{
    private Long id;
    private String placa;
    private String marca;
    private String modelo;
    private Long driverId;
}
