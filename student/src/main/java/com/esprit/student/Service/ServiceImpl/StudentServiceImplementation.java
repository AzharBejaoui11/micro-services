package com.esprit.student.Service.ServiceImpl;


import com.esprit.student.Model.Student;
import com.esprit.student.Repository.StudentRepository;
import com.esprit.student.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImplementation implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudent(Integer id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student updateStudent(Student student, Integer id) {
        Student existingStudent = studentRepository.findById(id).get();
        student.setEmail(existingStudent.getEmail());
        student.setFirstname(existingStudent.getFirstname());
        student.setLastname(existingStudent.getLastname());
        student.setSchoolId(existingStudent.getSchoolId());
        return studentRepository.save(student);
    }

    @Override
    public List<Student> findAllStudentsBySchool(Integer schoolId) {
        return studentRepository.findAllBySchoolId(schoolId);
    }
}
