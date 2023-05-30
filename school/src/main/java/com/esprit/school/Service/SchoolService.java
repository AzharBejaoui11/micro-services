package com.esprit.school.Service;

import com.esprit.school.Model.School;

import java.util.List;

public interface SchoolService {
    School saveStudent(School school);

    School getSchool(Integer id);

    List<School> getStudents();

    void deleteSchool(Integer id);

    School updateSchool(School school , Integer id);
}
