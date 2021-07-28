package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
// @Table(name="cars")
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String manufacturer;
	private String model;
	private Double cc;
	private Integer doors;
	
	public Car() {}

	public Car(Long id, String manufacturer, String model, Double cc, Integer doors) {
		super();
		this.id = id;
		this.manufacturer = manufacturer;
		this.model = model;
		this.cc = cc;
		this.doors = doors;
	}

	public Long getId() {
		return id;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public String getModel() {
		return model;
	}

	public Double getCc() {
		return cc;
	}

	public Integer getDoors() {
		return doors;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setCc(Double cc) {
		this.cc = cc;
	}

	public void setDoors(Integer doors) {
		this.doors = doors;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", manufacturer=" + manufacturer + ", model=" + model + ", cc=" + cc + ", doors="
				+ doors + "]";
	}
	
	
	
	
	
}
