package com.example.mappingDemo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mappingDemo.Model.Student;

public interface Repository extends JpaRepository<Student, Integer> {
	List<Student> findLaptopByStudentId(int id);
}
