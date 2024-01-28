package com.example.demo.student;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping
	public List<Student> index() {
		return this.studentService.students();
	}

    @PostMapping
    public Student store(@RequestBody Student student) {
        return this.studentService.createStudent(student);
    }

    @PutMapping(path = "{studentId}")
    public Student update(@PathVariable Long studentId, @RequestBody Student student) {
        return this.studentService.updateStudent(studentId, student);
    }

    @DeleteMapping(path = "{studentId}")
    public void delete(@PathVariable Long studentId) {
        this.studentService.deleteStudent(studentId);
    }
}