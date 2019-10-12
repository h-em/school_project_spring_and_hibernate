package com.sda.entryPoints;

import com.sda.dto.StudentDto;
import com.sda.dto.TeacherDto;
import com.sda.model.Student;
import com.sda.model.Teacher;
import com.sda.service.StudentService;
import com.sda.service.TeacherService;
import com.sda.transfer.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Halip on 06.10.2019.
 */
@Component
public class EntryPoints {

    private StudentService studentService;
    private TeacherService teacherService;

    /*
    public void execute(){
        Student student = new Student();
        student.setName("newStud");
        student.setAge(455);
        getStudentService().insertStudent(student);
    }*/

    public void executeStudentDto(StudentDto studentDto){
        studentService.insertStudent(studentDto);
    }

    public void executeTeacherDto(TeacherDto teacherDto){
        teacherService.insertTeacher(teacherDto);
    }

    public List<StudentDto> displayStudents(){
        return studentService.getStudentList();
    }

    public StudentService getStudentService() {
        return studentService;
    }

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public TeacherService getTeacherService() {
        return teacherService;
    }

    @Autowired
    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }
}
