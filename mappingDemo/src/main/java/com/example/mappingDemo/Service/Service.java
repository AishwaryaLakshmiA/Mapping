package com.example.mappingDemo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.mappingDemo.Model.Laptop;
import com.example.mappingDemo.Model.Student;
import com.example.mappingDemo.Repository.LaptopRepository;
import com.example.mappingDemo.Repository.Repository;

@org.springframework.stereotype.Service
public class Service {
	@Autowired private Repository r;
	@Autowired private LaptopRepository lr;
	public Student add(Student s) {
		return this.r.save(s);
	}
	public Student getS(int id) {
		return this.r.findById(id).get();
	}
	public List<Student> getStudentOfLaptop(int id){
		return this.r.findLaptopByStudentId(id);
	}
}
