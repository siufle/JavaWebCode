package com.cyx.jsp.dao;

import com.cyx.jsp.pojo.Student;

import java.util.List;

public interface StudentDao {

    List<Student> searchStudents();

    int updateStudent(String id, String name, String sex, String age);
}
