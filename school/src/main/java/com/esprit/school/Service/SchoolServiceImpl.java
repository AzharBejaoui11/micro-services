package com.esprit.school.Service;

import com.esprit.school.Model.School;
import com.esprit.school.Repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolServiceImpl implements  SchoolService {
    private final SchoolRepository schoolRepository;
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
}
