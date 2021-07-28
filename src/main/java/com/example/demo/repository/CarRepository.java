package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long>{

}
