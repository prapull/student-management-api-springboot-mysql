package com.example.SpringBootRestAPI.controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.processing.Find;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootRestAPI.entity.student;
import com.example.SpringBootRestAPI.repository.StudentRepository;

@RestController
public class StudentController {
	
	
	@Autowired
	StudentRepository repo;
	
	//get all the students
	@GetMapping("/students")
	public List<student> getAllStudents()
	{
		
		List<student> students =repo.findAll();
		
		return students;
	}
	
	
	@GetMapping("/students/{id}")
	public student getStudent(@PathVariable int id)
	{
		
		student Student = repo.findById(id).get();
		return Student;
	}
	
	
	@PostMapping("/students/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createStudent(@RequestBody student students)
	{
		repo.save(students);
	}
	
	@PutMapping("/students/update/{id}")
	public student updateStudents(@PathVariable int id)
	{
		student students = repo.findById(id).get();
		
		students.setName("Rameshwar");
		students.setPercentage(92);
		
		repo.save(students);
		return students;
	}
	
	
	@DeleteMapping("/students/delete/{id}")
	public void removeStudent(@PathVariable int id)
	{
		student students = repo.findById(id).get();
		repo.delete(students);
	}

}
