package com.cyx.jsp.service;

import com.cyx.jsp.pojo.Student;

import java.util.List;

public interface StudentService {

    List<Student> searchStudents();

    int updateStudent(String id, String name, String sex, String age);
}
