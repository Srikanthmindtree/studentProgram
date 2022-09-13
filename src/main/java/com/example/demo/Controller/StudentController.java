package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.StudentRepository;
import com.example.demo.Student.Student;

@RestController
public class StudentController {
	@Autowired
	private StudentRepository repo;
	@PostMapping("/addstudent")
	public String  saveStudent(@RequestBody Student s)
	{
		repo.save(s);
		return "student added succefully"+s.getId();
	}
	@GetMapping("/students")
public List<Student> getStudent()
{
		return repo.findAll();
}
	@GetMapping("/findStudent/{id}")
	public Optional<Student> getStudent(@PathVariable Integer id)
	{
		return repo.findById(id);
	}
	@GetMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable Integer id)
	{
		repo.deleteById(id);
		return "deleted student id"+id;
	}
	
	
	
}
