package com.sda.service;

import com.sda.dao.StudentDao;
import com.sda.dto.StudentDto;
import com.sda.model.Student;
import com.sda.transfer.StudentMapper;
import com.sda.validation.StudentValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Halip on 06.10.2019.
 */

@Service
public class StudentService {

    private StudentDao studentDao;
    private StudentMapper studentMapper;
    private StudentValidation studentValidation;


    public boolean insertStudent(StudentDto studentDto) {
        if (studentValidation.isDtoValid(studentDto)) {
            Student student = studentMapper.converteStudentDtoToStudent(studentDto);
            return getStudentDao().createEntity(student);
        }
        return false;
    }

    public List<StudentDto> getStudentList() {
         List<Student> studentList = getStudentDao().getStudentList();
         List<StudentDto> studentDtoList = new ArrayList<StudentDto>();

         for (Student student : studentList){
             if(getStudentValidation().isStudentValid(student)){
                 studentDtoList.add(studentMapper.convertStudentToStudentDto(student));
             }
         }

         if(studentDtoList.size()>0)
            return studentDtoList;
        return null;
    }

    public boolean deleteStudent(int id) {
        return getStudentDao().deleteEntity(id);
    }

    public void deleteStudentByName(String name) {
        getStudentDao().deleteEntityByName(name);
    }

    public StudentDao getStudentDao() {
        return studentDao;
    }

    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }


    public StudentMapper getStudentMapper() {
        return studentMapper;
    }

    @Autowired
    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    public StudentValidation getStudentValidation() {
        return studentValidation;
    }

    @Autowired
    public void setStudentValidation(StudentValidation studentValidation) {
        this.studentValidation = studentValidation;
    }
}
