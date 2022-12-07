package com.example.mappingDemo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mappingDemo.Model.Laptop;

public interface LaptopRepository extends JpaRepository<Laptop, Integer>{
	List<Laptop> findByLaptopId(int id);
	List<Laptop> findStudentByLaptopId(int id);
}
