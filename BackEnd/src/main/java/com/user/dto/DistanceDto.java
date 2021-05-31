package com.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DistanceDto{
    private long id;
    private long carId;
    private String origen;
    private String destino;
    private Date fecha_origen;
    private Date fecha_destino;
}
