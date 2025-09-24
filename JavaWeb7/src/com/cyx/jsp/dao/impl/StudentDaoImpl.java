package com.cyx.jsp.dao.impl;

import com.cyx.jsp.dao.StudentDao;
import com.cyx.jsp.handler.MultiResultHandler;
import com.cyx.jsp.jdbc.JdbcUtil;
import com.cyx.jsp.pojo.Student;

import java.util.List;

public class StudentDaoImpl implements StudentDao {

    @Override
    public List<Student> searchStudents() {
        String sql = "SELECT id,name,sex,age FROM student";
        return JdbcUtil.query(sql, new MultiResultHandler<>(Student.class));
    }

    @Override
    public int updateStudent(String id, String name, String sex, String age) {
        String sql = "UPDATE student SET name=?, sex=?, age=? WHERE id=?";
        return JdbcUtil.update(sql,name,sex,age,id);
    }
}
