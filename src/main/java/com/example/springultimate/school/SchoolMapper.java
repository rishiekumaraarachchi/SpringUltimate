package com.example.springultimate.school;

import org.springframework.stereotype.Service;

@Service
public class SchoolMapper {
    public School toSchool(SchoolDto schooldto) {

        return new School(schooldto.schoolName());
    }

    public SchoolDto toSchoolDto(School school) {

        return new SchoolDto(school.getSchoolName());
    }

}
