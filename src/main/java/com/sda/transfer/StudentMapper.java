package com.sda.transfer;

import com.sda.dto.StudentDto;
import com.sda.model.Student;
import org.springframework.stereotype.Component;

/**
 * Created by Halip on 12.10.2019.
 */
@Component
public class StudentMapper {

    public StudentDto convertStudentToStudentDto(Student student){
        StudentDto studentDto = new StudentDto();
        studentDto.setName(student.getName());
        studentDto.setAge(student.getAge());
        return studentDto;
    }

    public Student converteStudentDtoToStudent(StudentDto studentDto){
        Student student = new Student();
        student.setName(studentDto.getName());
        student.setAge(studentDto.getAge());
        return student;
    }

}
