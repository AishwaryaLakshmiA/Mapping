package com.example.mappingDemo.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GeneratorType;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	String name;
	
//	@OneToMany
//	@JoinColumn(name="student_id", referencedColumnName="student_id")
//	// here mappedBy is not working which means when i enter student details with
//	// laptopId it is not entering into the laptop table. so, used join column where
//	// name is p-key of student table and referencedColumnName is f-key in laptop table
//	private List<Laptop> laptop;
	
	@ManyToMany( cascade = {
          CascadeType.PERSIST,
          CascadeType.MERGE
      })
	@JoinTable(name = "st_lp",
     joinColumns = { @JoinColumn(name = "student_id") },
     inverseJoinColumns = { @JoinColumn(name = "laptop_id") })
	private List<Laptop> laptop;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Laptop> getLaptop() {
		return laptop;
	}

	public void setLaptop(List<Laptop> laptop) {
		this.laptop = laptop;
	}
	
	public void addLaptop(Laptop l) {
		this.laptop.add(l);
		l.getStudent().add(this);
	}

	
}
