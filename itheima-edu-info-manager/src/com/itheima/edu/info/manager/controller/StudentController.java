package com.itheima.edu.info.manager.controller;

import com.itheima.edu.info.manager.domain.Student;
import com.itheima.edu.info.manager.service.StudentService;

import java.sql.SQLOutput;
import java.util.Scanner;

public class StudentController {
    private StudentService studentService = new StudentService();
    private Scanner scanner = new Scanner(System.in);

    //开启学生管理系统，并展示学生管理系统菜单
    public void start() {
        studentLoop:
        while (true) {

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
                    deleteStudentById();
                    break;
                case "3":
                    System.out.println("修改学生");
                    updateStudent();
                    break;
                case "4":
                    System.out.println("查看学生");
                    findAllStudent();
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

    private void updateStudent() {
        // String updateId;
        //1.调用业务员获取学生对象数组
        Student[] students = studentService.findAllStudent();
        //2.判断是否有学生信息
        if (students == null) {
            System.out.println("查无信息，请添加后重新操作");
            return;
        }
//        while (true) {
//            //1.键盘录入要修改的学生ID
//            System.out.println("请输入 你要修改的学生ID");
//            updateId = scanner.next();
//            //2.判断id在容器中是否存在，如果不存在，一直录入
//            boolean exists = studentService.isExists(updateId);
//            if (!exists) {
//                System.out.println("您输入的ID不存在，请重新输入");
//            } else {
//                break;
//            }
//
//
//        }
        String updateId = inputStudentId();
//        System.out.println("请输入学生名称：");
//        String name = scanner.next();
//        System.out.println("请输入学生年龄：");
//        String age = scanner.next();
//        System.out.println("请输入学生生日：");
//        String birthday = scanner.next();
//        //2.将学生信息封装为学生对象
//        Student newStudent = new Student();
//        newStudent.setId(updateId);
//        newStudent.setName(name);
//        newStudent.setAge(age);
//        newStudent.setBirthday(birthday);
        Student newStudent = inputStudentInfo(updateId);
        studentService.updateStudent(updateId, newStudent);
        System.out.println("修改成功");
    }

    public void deleteStudentById() {

        //1.调用业务员获取学生对象数组
        Student[] students = studentService.findAllStudent();
        //2.判断是否有学生信息
        if (students == null) {
            System.out.println("查无信息，请添加后重新操作");
            return;
        }
//        while (true) {
//            //1.键盘录入要输出的学生ID
//            System.out.println("请输入 你要删除的学生ID");
//            delId = scanner.next();
//            //2.判断id在容器中是否存在，如果不存在，一直录入
//            boolean exists = studentService.isExists(delId);
//            if (!exists) {
//                System.out.println("您输入的ID不存在，请重新输入");
//            } else {
//                break;
//            }
//        }
        String delId = inputStudentId();
        //3.调用业务员deleteStudentById。根据id删除学生
        studentService.deleteStudentById(delId);
        //4.提示删除成功
        System.out.println("删除成功");


    }

    public void findAllStudent() {
        //1.调用业务员获取学生对象数组
        Student[] students = studentService.findAllStudent();
        //2.判断是否有学生信息
        if (students == null) {
            System.out.println("查无信息，请添加后重新查询");
            return;
        }
        //3.遍历学生信息
        System.out.println("学号\t\t姓名\t年龄\t生日");
        for (int i = 0; i < students.length; i++) {
            Student student = students[i];
            if (student != null) {
                System.out.println(student.getId() + "\t\t" + student.getName() + "\t" + student.getAge() + "\t" + student.getBirthday());
            }

        }

    }

    public void addStudent() {
        //studentService = new StudentService();
        //1.键盘接收学生信息
        Scanner scanner = new Scanner(System.in);
        String id;
        while (true) {
            System.out.println("请输入学生id：");
            id = scanner.next();
            boolean flag = studentService.isExists(id);
            if (flag) {
                System.out.println("学号已经被占用");
            } else {
                break;
            }
        }

//        System.out.println("请输入学生名称：");
//        String name = scanner.next();
//        System.out.println("请输入学生年龄：");
//        String age = scanner.next();
//        System.out.println("请输入学生生日：");
//        String birthday = scanner.next();
//        //2.将学生信息封装为学生对象
//        Student student = new Student();
//        student.setId(id);
//        student.setName(name);
//        student.setAge(age);
//        student.setBirthday(birthday);
        //3.将学生对象，传递给StudentService(业务员)中的addStudent方法
        Student student = inputStudentInfo(id);
        boolean result = studentService.addStudent(student);
        //4.根据返回的boolean结果,在控制台打印 成功/失败
        if (result) {
            System.out.println("添加成功！");
        } else {
            System.out.println("添加失败！！！");
        }

    }

    public String inputStudentId() {
        String id;
        while (true) {
            //1.键盘录入要修改的学生ID
            System.out.println("请输入学生ID");
            id = scanner.next();
            //2.判断id在容器中是否存在，如果不存在，一直录入
            boolean exists = studentService.isExists(id);
            if (!exists) {
                System.out.println("您输入的ID不存在，请重新输入");
            } else {
                break;
            }
        }
        return id;
    }

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

