package com.itheima.edu.info.manager.service;

import com.itheima.edu.info.manager.dao.StudentDao;
import com.itheima.edu.info.manager.domain.Student;

public class StudentService {
    public boolean addStudent(Student student) {
//        1.创建StudentDao(库管)
        StudentDao studentDao = new StudentDao();
//        2.将学生对象，传递给StudentDao中的addStudent()方法
       // boolean result = studentDao.addStudent(student);
//        3.将返回的boolean类型结果返还给StudentController
        //return  result;
        return studentDao.addStudent(student);
    }
}
