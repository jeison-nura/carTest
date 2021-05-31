package com.user.repository;

import com.user.entity.DriverEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IDriverRepository extends JpaRepository<DriverEntity,Long>, CrudRepository<DriverEntity,Long> {
}

