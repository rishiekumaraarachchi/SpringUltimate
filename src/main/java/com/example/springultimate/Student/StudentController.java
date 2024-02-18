package com.example.springultimate.Student;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public StudentResponseDto saveStudent(@Valid @RequestBody StudentDto studentDto) {
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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException ex) {
        var errors = new HashMap<String, String>();
        ex.getBindingResult().getFieldErrors().forEach(
                error ->{
                    var fieldName =((FieldError) error).getField();
                    var errorMessage = error.getDefaultMessage();
                    errors.put(fieldName, errorMessage);
                } );
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

}
