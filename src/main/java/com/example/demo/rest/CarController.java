package com.example.demo.rest;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Car;
import com.example.demo.repository.CarRepository;

@RestController
@RequestMapping("/api")

public class CarController {
	
	private final Logger log = LoggerFactory.getLogger(CarController.class);

	// dependencia
	private CarRepository carRepository; 
	
	public CarController(CarRepository carRepository) { // spring inyecta la dependencia
		this.carRepository = carRepository;
	}
	
	/**
	 * http://localhost:8080/api/cars/1
	 */
	@GetMapping("/cars/{id}")
	public ResponseEntity<Car> findOne(@PathVariable Long id) {
		log.info("REST request to find one car");

		Optional<Car> carOpt = this.carRepository.findById(id);
		
		if (carOpt.isPresent()) 
			return ResponseEntity.ok(carOpt.get());
		
		return ResponseEntity.notFound().build();
		
	}
	
	/**
	 * http://localhost:8080/api/cars
	 */
	@GetMapping("/cars")
	public List<Car> findAll(){
		log.info("REST request to find all cars");
		return this.carRepository.findAll();
	}
	
	// create one
	@PostMapping("/cars")
	public ResponseEntity<Car> create(@RequestBody Car car){
		log.info("REST request to create a new car");
		
		if (car.getId() != null) { // HAY ID - EL COCHE YA EXISTE NO PUEDO CREARLO DE NUEVO
			log.warn("Trying to create a new car with existent id");
			return ResponseEntity.badRequest().build();
		}

		return ResponseEntity.ok(this.carRepository.save(car));
		
	}
	
	// update 
	@PutMapping("/cars")
	public ResponseEntity<Car> update(@RequestBody Car car) {
		log.info("REST request to update an existing car");
		if (car.getId() == null) { // NO HAY ID - POR TANTO NO EXISTE EL COCHE A ACTUALIZAR
			log.warn("Trying to update an existing car without id");
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok(this.carRepository.save(car));
		
	}
	
	// delete one
	@DeleteMapping("/cars/{id}")
	public ResponseEntity<Car> delete(@PathVariable Long id){
		log.info("REST request to delete an existing car");
		
		this.carRepository.deleteById(id);
		
		return ResponseEntity.noContent().build();
		
	}
	
	// delete all
	
	@DeleteMapping("/cars")
	public ResponseEntity<Car> deleteAll(){
		log.info("REST request to delete all cars");
		
		this.carRepository.deleteAll();
		
		return ResponseEntity.noContent().build();
		
	}
	
}
