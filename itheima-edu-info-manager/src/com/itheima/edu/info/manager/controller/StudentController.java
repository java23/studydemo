package com.itheima.edu.info.manager.controller;

import com.itheima.edu.info.manager.domain.Student;
import com.itheima.edu.info.manager.service.StudentService;

import java.sql.SQLOutput;
import java.util.Scanner;

public class StudentController {
    //开启学生管理系统，并展示学生管理系统菜单
    public void start() {
        studentLoop:
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("--------欢迎来到 <学生> 管理系统--------");
            System.out.println("请输入您的选择: 1.添加学生  2.删除学生  3.修改学生  4.查看学生  5.退出");
            //菜单搭建
            String choice = scanner.next();
            switch (choice) {
                case "1":
                    System.out.println("添加学生");
                    addStudent();
                    break;
                case "2":
                    System.out.println("删除学生");
                    break;
                case "3":
                    System.out.println("修改学生");
                    break;
                case "4":
                    System.out.println("查看学生");
                    break;
                case "5":
                    System.out.println("退出");
                    break studentLoop;
                default:
                    System.out.println("您的输入有误，请重新输入");
                    break;
            }
        }
    }

    public void addStudent() {
        //1.键盘接收学生信息
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学生id：");
        String id = scanner.next();
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
        //3.将学生对象，传递给StudentService(业务员)中的addStudent方法
        StudentService studentService = new StudentService();
        boolean result = studentService.addStudent(student);
        //4.根据返回的boolean结果,在控制台打印 成功/失败
        if(result){
            System.out.println("添加成功！");
        }else {
            System.out.println("添加失败！！！");
        }

    }


}
