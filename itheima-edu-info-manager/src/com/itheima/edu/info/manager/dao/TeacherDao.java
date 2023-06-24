package com.itheima.edu.info.manager.dao;

import com.itheima.edu.info.manager.domain.Teacher;

public class TeacherDao {
    //1.创建老师对象数组
    private static Teacher[] Teachers = new  Teacher[5];
    public boolean addTeacher(Teacher teacher) {

        //2.添加老师到数组
        //2.1 定义变量index为-1，假设数组已经全部存满，没有null的元素
        int index = -1;
        //2.2 遍历数组取出每一个元素，判断是否是null
        for (int i = 0; i < Teachers.length; i++) {
            Teacher Teacher = Teachers[i];
            //2.3 如果为null，让index变量记录当前索引位置，并使用break结束循环遍历
            if(null==Teacher){
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
            Teachers[index]=teacher;
            return true;
        }

    }

    public Teacher[] findAllTeacher() {
        return  Teachers;
    }

    public void deleteTeacherById(String delId) {
        int index = getIndex(delId);
        Teachers[index] =null;
    }
    public int getIndex(String id){
        int index = -1;
        for (int i = 0; i < Teachers.length; i++) {
            Teacher Teacher = Teachers[i];
            if(Teacher != null && Teacher.getId().equals(id)){
                index= i;
            break;
            }
        }
        return  index;
    }

    public void updateTeacher(String updateId, Teacher newTeacher) {
        //1.查找updateId索引位置
        int index = getIndex(updateId);
        //2.将该索引位置，使用新的老师对象代替
        Teachers[index] = newTeacher;

    }
}
