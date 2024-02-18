package com.example.springultimate.Student;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public StudentResponseDto saveStudent(StudentDto studentDto) {
        var student = studentMapper.toStudent(studentDto);
        studentRepository.save(student);
        return studentMapper.toStudentResponseDto(student);
    }

    public List<StudentResponseDto> findAllStudents() {
        return studentRepository.findAll().
                stream().
                map(studentMapper::toStudentResponseDto).
                collect(Collectors.toList());
    }

    public StudentResponseDto findSingleStudents(Integer id) {
        return studentRepository.findById(id).
                map(studentMapper::toStudentResponseDto).// transforms each element of a stream into another object using a given function.
                orElse(null);
    }

    public List<StudentResponseDto> findByFirstname(String name) {
        return studentRepository.findAllByFirstnameContaining(name).
                stream().//called on a collection or an array to create a stream of elements.
                map(studentMapper::toStudentResponseDto).// convert each Student object to a StudentResponseDto object.
                collect(Collectors.toList());//This terminal operation collects the elements of the stream into a list. It uses the Collectors.
        // toList() collector to accumulate the elements into a List<StudentResponseDto>.
    }

    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }
}
