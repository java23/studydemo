package com.itheima.edu.info.manager.dao;

import com.itheima.edu.info.manager.domain.Student;

public interface BaseStudentDao {
    //1.创建学生对象数组

    public abstract boolean addStudent(Student stu);

    public abstract Student[] findAllStudent()  ;
    public abstract void deleteStudentById(String delId)  ;
    public abstract int getIndex(String id) ;
    public abstract void updateStudent(String updateId, Student newStudent)  ;
}
