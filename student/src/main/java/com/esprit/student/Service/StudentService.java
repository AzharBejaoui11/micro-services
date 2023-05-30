package com.esprit.student.Service;

import com.esprit.student.Model.Student;

import java.util.List;

public interface StudentService {

    Student saveStudent(Student student);

    Student getStudent(Integer id);

    List<Student> getStudents();

    void deleteStudent(Integer id);

    Student updateStudent(Student student , Integer id);

    List<Student>  findAllStudentsBySchool(Integer schoolId);




}
