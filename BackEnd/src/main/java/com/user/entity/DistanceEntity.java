package com.user.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;


@Entity
@Table(name="distances")
/*@NamedQueries({
        @NamedQuery(name = "DriverEntity.findById", query = "from DriverEntity driver inner join driver.id where id = :idDriver")
})*/


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DistanceEntity {
    @Id
    @Column(name="id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "distance_generator")
    @SequenceGenerator(name = "distance_generator",sequenceName = "distance_seq", allocationSize = 1)
    private long id;

    @NotNull
    @NotBlank
    @NotEmpty
    @Column(name = "origen")
    private String origen;

    @NotNull
    @NotBlank
    @NotEmpty
    @Column(name = "destino")
    private String destino;

    @NotNull
    @NotBlank
    @NotEmpty
    @Column(name = "fecha_origen")
    private Date fecha_origen;

    @NotNull
    @NotBlank
    @NotEmpty
    @Column(name = "fecha_destino")
    private Date fecha_destino;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id", nullable = false)
    private CarEntity car;

}
