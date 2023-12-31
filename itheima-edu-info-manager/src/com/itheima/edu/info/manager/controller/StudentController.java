package com.itheima.edu.info.manager.controller;

import com.itheima.edu.info.manager.domain.Student;
import com.itheima.edu.info.manager.service.StudentService;

import java.sql.SQLOutput;
import java.util.Scanner;

public class StudentController extends BaseStudentController {

    private Scanner scanner = new Scanner(System.in);

    public Student inputStudentInfo(String id) {
        System.out.println("请输入学生名称：");
        String name = scanner.next();
        System.out.println("请输入学生年龄：");
        String age = scanner.next();
        System.out.println("请输入学生生日：");
        String birthday = scanner.next();
        //2.将学生信息封装为学生对象
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setAge(age);
        student.setBirthday(birthday);
        return student;
    }

}

