package com.example.mappingDemo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.mappingDemo.Model.Laptop;
import com.example.mappingDemo.Repository.LaptopRepository;

@org.springframework.stereotype.Service
public class LaptopService {
	@Autowired private LaptopRepository lr;
	
	public List<Laptop> getL(int id) {
		return this.lr.findByLaptopId(id);
	}
	public List<Laptop> getLaptopOfStudent(int id) {
		return this.lr.findStudentByLaptopId(id);
	}
}
