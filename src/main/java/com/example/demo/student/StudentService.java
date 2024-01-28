package com.example.demo.student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentService {
	private final StudentRepository studentRepository;

	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}



 public List<Student> students() {
	return this.studentRepository.findAll();
 }

 public Student createStudent(Student student) {
	Optional<Student> studentByEmail = this.studentRepository.findByEmail(student.getEmail());

	if (studentByEmail.isPresent()) {
		throw new IllegalArgumentException("Email already taken");
	}

	return this.studentRepository.save(student);
 }

 public Student updateStudent(Long studentId, Student student) {
	Optional<Student> studentToUpdate = this.studentRepository.findById(studentId);

	if (studentToUpdate.isPresent()) {
		student.setId(studentId);
		return this.studentRepository.save(student);
	}

	throw new IllegalStateException();
 }


 public void deleteStudent(Long studentId) {
	this.studentRepository.deleteById(studentId);
 }
}