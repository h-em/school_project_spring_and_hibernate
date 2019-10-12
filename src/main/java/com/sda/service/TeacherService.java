package com.sda.service;

import com.sda.dao.StudentDao;
import com.sda.dao.TeacherDao;
import com.sda.dto.StudentDto;
import com.sda.dto.TeacherDto;
import com.sda.model.Student;
import com.sda.model.Teacher;
import com.sda.transfer.StudentMapper;
import com.sda.transfer.TeacherMapper;
import com.sda.validation.StudentValidation;
import com.sda.validation.TeacherValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Halip on 06.10.2019.
 */
@Service
public class TeacherService {

    private TeacherDao teacherDao;
    private TeacherValidator teacherValidator;
    private TeacherMapper teacherMapper;


    public boolean insertTeacher(TeacherDto teacherDto) {
        if (getTeacherValidator().isDtoValid(teacherDto)) {
            Teacher teacher = getTeacherMapper().convertTeacherDtoToTeacher(teacherDto);
            return getTeacherDao().createEntity(teacher);
        }
        return false;
    }

    public boolean deleteStudent(int id) {
        return getTeacherDao().deleteEntity(id);
    }

    public void deleteStudentByName(String name) {
        getTeacherDao().deleteEntityByName(name);
    }


    public TeacherValidator getTeacherValidator() {
        return teacherValidator;
    }

    @Autowired
    public void setTeacherValidator(TeacherValidator teacherValidator) {
        this.teacherValidator = teacherValidator;
    }

    public TeacherMapper getTeacherMapper() {
        return teacherMapper;
    }

    @Autowired
    public void setTeacherMapper(TeacherMapper teacherMapper) {
        this.teacherMapper = teacherMapper;
    }

    public TeacherDao getTeacherDao() {
        return teacherDao;
    }

    @Autowired
    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }
}
