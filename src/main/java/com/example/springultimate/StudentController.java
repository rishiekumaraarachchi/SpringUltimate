package com.example.springultimate;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentController(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;

    }

    @PostMapping("/students")
    public StudentResponseDto post(@RequestBody StudentDto studentDto) {
        var student = studentMapper.toStudent(studentDto);
        var savedStudent = studentRepository.save(student);
        return studentMapper.toStudentResponseDto(savedStudent);
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
