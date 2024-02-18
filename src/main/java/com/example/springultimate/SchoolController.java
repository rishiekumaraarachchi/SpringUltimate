package com.example.springultimate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SchoolController {

    private final SchoolRepository schoolRepository;

    public SchoolController(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @PostMapping("/schools")
    public SchoolDto createSchool(@RequestBody SchoolDto schooldto) {
        var school = toSchool(schooldto);
        schoolRepository.save(school);
        return schooldto;
    }

    private School toSchool(SchoolDto schooldto) {
        return new School(schooldto.schoolName());
    }

    private SchoolDto toSchoolDto(School school) {
        return new SchoolDto(school.getSchoolName());
    }

    @GetMapping("/schools")
    public List<SchoolDto> findAllSchools() {
        return schoolRepository.findAll().stream()
                .map(this::toSchoolDto)
                .collect(Collectors.toList());
    }
}
