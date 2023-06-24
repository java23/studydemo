package com.itheima.edu.info.manager.service;

import com.itheima.edu.info.manager.dao.TeacherDao;
import com.itheima.edu.info.manager.domain.Teacher;

public class TeacherService {
    private TeacherDao TeacherDao = new TeacherDao();
    public boolean addTeacher(Teacher Teacher) {
//        1.创建TeacherDao(库管)
        //TeacherDao = new TeacherDao();
//        2.将老师对象，传递给TeacherDao中的addTeacher()方法
        // boolean result = TeacherDao.addTeacher(Teacher);
//        3.将返回的boolean类型结果返还给TeacherController
        //return  result;
        return TeacherDao.addTeacher(Teacher);
    }

    public boolean isExists(String id) {

        Teacher[] Teachers = TeacherDao.findAllTeacher();
        //默认id在数组中不存在
        boolean exists = false;
        for (int i = 0; i < Teachers.length; i++) {
            Teacher Teacher = Teachers[i];
            if (Teacher != null && Teacher.getId().equals(id)) {
                exists = true;
                break;
            }
        }
        return exists;
    }

    public Teacher[] findAllTeacher() {
        //查询老师全部信息
        Teacher[] allTeacher = TeacherDao.findAllTeacher();
        boolean flag = false;
        for (int i = 0; i < allTeacher.length; i++) {
            Teacher Teacher = allTeacher[i];
            if (Teacher!=null){
                flag = true;
                break;
            }
        }
        if (flag){
            return  allTeacher;
        }else{
            return null;
        }

    }

    public void deleteTeacherById(String delId) {
        TeacherDao.deleteTeacherById(delId);
    }

    public void updateTeacher(String updateId, Teacher newTeacher) {
        TeacherDao.updateTeacher(updateId,newTeacher);
    }
}
