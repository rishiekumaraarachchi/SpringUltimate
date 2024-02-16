package com.example.springultimate;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FirstController {
private final StudentRepository studentRepository;

    public FirstController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping("/students")
    public Student post(@RequestBody Student student) {
        return  studentRepository.save(student);
    }

    @GetMapping("/students")

    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/students/{id}")

    public Student findSingleStudents(
            @PathVariable("id") Integer id
    ) {
        return studentRepository.findById(id).orElse(null);
    }


    @GetMapping("/students/search/{name}")

    public List<Student> findByFirstname(
            @PathVariable("name") String name
    ) {
        return studentRepository.findAllByFirstnameContaining(name);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(
            @PathVariable("id") Integer id
    ) {
        studentRepository.deleteById(id);
    }

}
