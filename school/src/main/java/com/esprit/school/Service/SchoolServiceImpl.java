package com.esprit.school.Service;

import com.esprit.school.Model.FullSchoolResponse;
import com.esprit.school.Model.School;
import com.esprit.school.Repository.SchoolRepository;
import com.esprit.school.StudentClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolServiceImpl implements  SchoolService {
    private final SchoolRepository schoolRepository;
    private final StudentClient studentClient;
    @Override
    public School saveStudent(School school) {
        return schoolRepository.save(school);
    }

    @Override
    public School getSchool(Integer id) {
        return schoolRepository.findById(id).get();
    }

    @Override
    public List<School> getStudents() {
        return schoolRepository.findAll();
    }

    @Override
    public void deleteSchool(Integer id) {
        schoolRepository.findById(id).get();
    }

    @Override
    public School updateSchool(School school, Integer id) {
        School existingStudent = schoolRepository.findById(id).get();
        school.setEmail(existingStudent.getEmail());
        school.setName(existingStudent.getName());
        return schoolRepository.save(school);
    }

    @Override
    public FullSchoolResponse findSchoolWithStudents(Integer schoolId) {
        var school = schoolRepository.findById(schoolId).orElse(School.builder().name("notFOUND").email("NOTFOUND").build());
        var students = studentClient.findAllStudentsBySchool(schoolId);// from the students service
        return FullSchoolResponse.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();
    }

}
