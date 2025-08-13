package com.example.controller;

import com.example.bean.Student;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    private List<Student> students = new ArrayList<>();

    // Create - POST
    @PostMapping
    public String addStudent(@RequestBody Student student) {
        students.add(student);
        return "Student added successfully!";
    }

    // Read All - GET
    @GetMapping
    public List<Student> getAllStudents() {
        return students;
    }

    // Read by ID - GET
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        return students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Update - PUT
    @PutMapping("/{id}")
    public String updateStudent(@PathVariable int id, @RequestBody Student updatedStudent) {
        for (Student s : students) {
            if (s.getId() == id) {
                s.setName(updatedStudent.getName());
                s.setCourse(updatedStudent.getCourse());
                return "Student updated successfully!";
            }
        }
        return "Student not found!";
    }

    // Delete - DELETE
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        boolean removed = students.removeIf(s -> s.getId() == id);
        return removed ? "Student deleted successfully!" : "Student not found!";
    }
}
