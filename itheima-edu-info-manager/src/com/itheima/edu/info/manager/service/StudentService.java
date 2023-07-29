package com.itheima.edu.info.manager.service;

import com.itheima.edu.info.manager.dao.BaseStudentDao;
import com.itheima.edu.info.manager.dao.OtherStudentDao;
import com.itheima.edu.info.manager.dao.StudentDao;
import com.itheima.edu.info.manager.domain.Student;
import com.itheima.edu.info.manager.factory.StudentDaoFactory;

public class StudentService {
    //private OtherStudentDao studentDao = new OtherStudentDao();
    private BaseStudentDao studentDao = StudentDaoFactory.getStudentDao();
    public boolean addStudent(Student student) {
//        1.创建StudentDao(库管)
        //studentDao = new StudentDao();
//        2.将学生对象，传递给StudentDao中的addStudent()方法
        // boolean result = studentDao.addStudent(student);
//        3.将返回的boolean类型结果返还给StudentController
        //return  result;
        return studentDao.addStudent(student);
    }

    public boolean isExists(String id) {

        Student[] students = studentDao.findAllStudent();
        //默认id在数组中不存在
        boolean exists = false;
        for (int i = 0; i < students.length; i++) {
            Student student = students[i];
            if (student != null && student.getId().equals(id)) {
                exists = true;
                break;
            }
        }
        return exists;
    }

    public Student[] findAllStudent() {
        //查询学生全部信息
        Student[] allStudent = studentDao.findAllStudent();
        boolean flag = false;
        for (int i = 0; i < allStudent.length; i++) {
            Student student = allStudent[i];
            if (student!=null){
                flag = true;
                break;
            }
        }
        if (flag){
            return  allStudent;
        }else{
            return null;
        }

    }

    public void deleteStudentById(String delId) {
        studentDao.deleteStudentById(delId);
    }

    public void updateStudent(String updateId, Student newStudent) {
        studentDao.updateStudent(updateId,newStudent);
    }
}
