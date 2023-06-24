package com.itheima.edu.info.manager.controller;

import com.itheima.edu.info.manager.domain.Teacher;
import com.itheima.edu.info.manager.service.TeacherService;

import java.util.Scanner;

public class TeacherController {
    private TeacherService TeacherService = new TeacherService();
    private Scanner scanner = new Scanner(System.in);

    //开启老师管理系统，并展示老师管理系统菜单
    public void start() {
        TeacherLoop:
        while (true) {

            System.out.println("--------欢迎来到 <老师> 管理系统--------");
            System.out.println("请输入您的选择: 1.添加老师  2.删除老师  3.修改老师  4.查看老师  5.退出");
            //菜单搭建
            String choice = scanner.next();
            switch (choice) {
                case "1":
                    System.out.println("添加老师");
                    addTeacher();
                    break;
                case "2":
                    System.out.println("删除老师");
                    deleteTeacherById();
                    break;
                case "3":
                    System.out.println("修改老师");
                    updateTeacher();
                    break;
                case "4":
                    System.out.println("查看老师");
                    findAllTeacher();
                    break;
                case "5":
                    System.out.println("退出");
                    break TeacherLoop;
                default:
                    System.out.println("您的输入有误，请重新输入");
                    break;
            }
        }
    }

    private void updateTeacher() {
        // String updateId;
        //1.调用业务员获取老师对象数组
        Teacher[] Teachers = TeacherService.findAllTeacher();
        //2.判断是否有老师信息
        if (Teachers == null) {
            System.out.println("查无信息，请添加后重新操作");
            return;
        }
//        while (true) {
//            //1.键盘录入要修改的老师ID
//            System.out.println("请输入 你要修改的老师ID");
//            updateId = scanner.next();
//            //2.判断id在容器中是否存在，如果不存在，一直录入
//            boolean exists = TeacherService.isExists(updateId);
//            if (!exists) {
//                System.out.println("您输入的ID不存在，请重新输入");
//            } else {
//                break;
//            }
//
//
//        }
        String updateId = inputTeacherId();
//        System.out.println("请输入老师名称：");
//        String name = scanner.next();
//        System.out.println("请输入老师年龄：");
//        String age = scanner.next();
//        System.out.println("请输入老师生日：");
//        String birthday = scanner.next();
//        //2.将老师信息封装为老师对象
//        Teacher newTeacher = new Teacher();
//        newTeacher.setId(updateId);
//        newTeacher.setName(name);
//        newTeacher.setAge(age);
//        newTeacher.setBirthday(birthday);
        Teacher newTeacher = inputTeacherInfo(updateId);
        TeacherService.updateTeacher(updateId, newTeacher);
        System.out.println("修改成功");
    }

    public void deleteTeacherById() {

        //1.调用业务员获取老师对象数组
        Teacher[] Teachers = TeacherService.findAllTeacher();
        //2.判断是否有老师信息
        if (Teachers == null) {
            System.out.println("查无信息，请添加后重新操作");
            return;
        }
//        while (true) {
//            //1.键盘录入要输出的老师ID
//            System.out.println("请输入 你要删除的老师ID");
//            delId = scanner.next();
//            //2.判断id在容器中是否存在，如果不存在，一直录入
//            boolean exists = TeacherService.isExists(delId);
//            if (!exists) {
//                System.out.println("您输入的ID不存在，请重新输入");
//            } else {
//                break;
//            }
//        }
        String delId = inputTeacherId();
        //3.调用业务员deleteTeacherById。根据id删除老师
        TeacherService.deleteTeacherById(delId);
        //4.提示删除成功
        System.out.println("删除成功");


    }

    public void findAllTeacher() {
        //1.调用业务员获取老师对象数组
        Teacher[] Teachers = TeacherService.findAllTeacher();
        //2.判断是否有老师信息
        if (Teachers == null) {
            System.out.println("查无信息，请添加后重新查询");
            return;
        }
        //3.遍历老师信息
        System.out.println("编号\t\t姓名\t年龄\t生日");
        for (int i = 0; i < Teachers.length; i++) {
            Teacher Teacher = Teachers[i];
            if (Teacher != null) {
                System.out.println(Teacher.getId() + "\t\t" + Teacher.getName() + "\t" + Teacher.getAge() + "\t" + Teacher.getBirthday());
            }

        }

    }

    public void addTeacher() {
        //TeacherService = new TeacherService();
        //1.键盘接收老师信息
        Scanner scanner = new Scanner(System.in);
        String id;
        while (true) {
            System.out.println("请输入老师id：");
            id = scanner.next();
            boolean flag = TeacherService.isExists(id);
            if (flag) {
                System.out.println("编号已经被占用");
            } else {
                break;
            }
        }

//        System.out.println("请输入老师名称：");
//        String name = scanner.next();
//        System.out.println("请输入老师年龄：");
//        String age = scanner.next();
//        System.out.println("请输入老师生日：");
//        String birthday = scanner.next();
//        //2.将老师信息封装为老师对象
//        Teacher Teacher = new Teacher();
//        Teacher.setId(id);
//        Teacher.setName(name);
//        Teacher.setAge(age);
//        Teacher.setBirthday(birthday);
        //3.将老师对象，传递给TeacherService(业务员)中的addTeacher方法
        Teacher Teacher = inputTeacherInfo(id);
        boolean result = TeacherService.addTeacher(Teacher);
        //4.根据返回的boolean结果,在控制台打印 成功/失败
        if (result) {
            System.out.println("添加成功！");
        } else {
            System.out.println("添加失败！！！");
        }

    }

    public String inputTeacherId() {
        String id;
        while (true) {
            //1.键盘录入要修改的老师ID
            System.out.println("请输入老师ID");
            id = scanner.next();
            //2.判断id在容器中是否存在，如果不存在，一直录入
            boolean exists = TeacherService.isExists(id);
            if (!exists) {
                System.out.println("您输入的ID不存在，请重新输入");
            } else {
                break;
            }
        }
        return id;
    }

    public Teacher inputTeacherInfo(String id) {
        System.out.println("请输入老师名称：");
        String name = scanner.next();
        System.out.println("请输入老师年龄：");
        String age = scanner.next();
        System.out.println("请输入老师生日：");
        String birthday = scanner.next();
        //2.将老师信息封装为老师对象
        Teacher Teacher = new Teacher();
        Teacher.setId(id);
        Teacher.setName(name);
        Teacher.setAge(age);
        Teacher.setBirthday(birthday);
        return Teacher;
    }

}

