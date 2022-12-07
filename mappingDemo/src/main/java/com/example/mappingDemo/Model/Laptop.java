package com.example.mappingDemo.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
public class Laptop {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="laptop_id")
	private int id;
	private String laptopModel;

//	@ManyToOne
//	private Student student;
	
	@ManyToMany(cascade = {
	          CascadeType.PERSIST,
	          CascadeType.MERGE
	      }, mappedBy = "laptop")
	private List<Student> student;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLaptopModel() {
		return laptopModel;
	}

	public void setLaptopModel(String laptopModel) {
		this.laptopModel = laptopModel;
	}

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}
	
	

}
