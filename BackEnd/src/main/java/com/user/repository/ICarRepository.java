package com.user.repository;

import com.user.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICarRepository extends JpaRepository<CarEntity,Long>, CrudRepository<CarEntity,Long> {
}
