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
@Table(name="drivers")
/*@NamedQueries({
        @NamedQuery(name = "DriverEntity.findById", query = "from DriverEntity driver inner join driver.id where id = :idDriver")
})*/


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DriverEntity {
    @Id
    @Column(name="id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "driver_generator")
    @SequenceGenerator(name = "driver_generator",sequenceName = "driver_seq", allocationSize = 1)
    private long id;

    @NotNull
    @NotBlank
    @NotEmpty
    @Column(name = "nombre")
    private String nombre;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "driver")
    private List<CarEntity> car;

}
