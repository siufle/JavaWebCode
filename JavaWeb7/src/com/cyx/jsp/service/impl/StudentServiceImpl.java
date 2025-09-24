package com.cyx.jsp.service.impl;

import com.cyx.jsp.dao.StudentDao;
import com.cyx.jsp.dao.impl.StudentDaoImpl;
import com.cyx.jsp.pojo.Student;
import com.cyx.jsp.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao = new StudentDaoImpl();

    @Override
    public List<Student> searchStudents() {
        return studentDao.searchStudents();
    }

    @Override
    public int updateStudent(String id, String name, String sex, String age) {
        return studentDao.updateStudent(id,name,sex,age);
    }
}
