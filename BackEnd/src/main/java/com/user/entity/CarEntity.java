package com.user.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
@Table(name="cars")
/*@NamedQueries({
        @NamedQuery(name = "CarEntity.findById", query = "from CarEntity car inner join car.id where id = :idCar")
})*/


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarEntity {
    @Id
    @Column(name="id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_generator")
    @SequenceGenerator(name = "car_generator",sequenceName = "car_seq", allocationSize = 1)
    private long id;

    @NotNull
    @NotBlank
    @NotEmpty
    @Column(name = "placa")
    private String placa;

    @NotNull
    @NotBlank
    @NotEmpty
    @Column(name = "modelo")
    private String modelo;

    @NotNull
    @NotBlank
    @NotEmpty
    @Column(name = "marca")
    private String marca;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "conductor_id", nullable = false)
    private DriverEntity driver;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "car")
    private List<DistanceEntity> distance;
}
