package com.itheima.edu.info.manager.dao;

import com.itheima.edu.info.manager.domain.Student;

public class StudentDao {
    public boolean addStudent(Student stu) {
        //1.创建学生对象数组
        Student[] students = new  Student[5];
        //2.添加学生到数组
        //2.1 定义变量index为-1，假设数组已经全部存满，没有null的元素
        int index = -1;
        //2.2 遍历数组取出每一个元素，判断是否是null
        for (int i = 0; i < students.length; i++) {
            Student student = new Student();
            //2.3 如果为null，让index变量记录当前索引位置，并使用break结束循环遍历
            if(null==student){
                index = i;
                break;
            }
        }

        // 3. 返回是否添加成功的boolean类型状态
        // 装满了
        if (index==-1){
            return false;
        }else {
            // 没有装满, 正常添加, 返回true
            students[index]=stu;
            return true;
        }

    }
}
