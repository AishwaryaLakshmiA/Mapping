package com.example.mappingDemo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mappingDemo.Model.Laptop;
import com.example.mappingDemo.Model.Student;
import com.example.mappingDemo.Service.LaptopService;
import com.example.mappingDemo.Service.Service;

@RestController
public class Controller {
	@Autowired private Service service;
	@Autowired private LaptopService ls;
	
	@PostMapping("/student")
	public ResponseEntity<Student> add(@RequestBody Student s){
		return ResponseEntity.ok(this.service.add(s));
	}
	@GetMapping("/student/{id}")
	public ResponseEntity<Student> add(@PathVariable int id){
		return ResponseEntity.ok(this.service.getS(id));
	}
	@GetMapping("/student/{id}/lap")
	public ResponseEntity<List<Laptop>> getL(@PathVariable int id){
		return ResponseEntity.ok(this.ls.getLaptopOfStudent(id));
	}
	@GetMapping("/lap/{id}/student")
	public ResponseEntity<List<Student>> getS(@PathVariable int id){
		return ResponseEntity.ok(this.service.getStudentOfLaptop(id));
	}
}
