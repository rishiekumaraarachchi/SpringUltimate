package com.example.springultimate.Student;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public StudentResponseDto saveStudent(@RequestBody StudentDto studentDto) {
        return this.studentService.saveStudent(studentDto);
    }

    @GetMapping("/students")

    public List<StudentResponseDto> findAllStudents() {
        return studentService.findAllStudents();
    }

    @GetMapping("/students/{id}")

    public StudentResponseDto findSingleStudents(
            @PathVariable("id") Integer id
    ) {
        return studentService.findSingleStudents(id);
    }


    @GetMapping("/students/search/{name}")

    public List<StudentResponseDto> findByFirstname(
            @PathVariable("name") String name
    ) {
        return studentService.findByFirstname(name);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(
            @PathVariable("id") Integer id
    ) {
        studentService.deleteStudent(id);
    }

}
