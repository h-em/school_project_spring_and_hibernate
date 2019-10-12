package com.sda.transfer;

import com.sda.dto.TeacherDto;
import com.sda.model.Teacher;
import org.springframework.stereotype.Component;

/**
 * Created by Halip on 12.10.2019.
 */

@Component
public class TeacherMapper {

    public TeacherDto convertTeacherToTeacherDto(Teacher teacher){
        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setName(teacher.getName());
        teacherDto.setJob(teacher.getJob());
        teacherDto.setAge(teacher.getAge());
        return teacherDto;
    }

    public Teacher convertTeacherDtoToTeacher(TeacherDto teacherDto){
        Teacher teacher  = new Teacher();
        teacher.setName(teacherDto.getName());
        teacher.setJob(teacherDto.getJob());
        teacher.setAge(teacherDto.getAge());
        return teacher;
    }
}
