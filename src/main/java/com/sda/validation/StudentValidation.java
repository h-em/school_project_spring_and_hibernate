package com.sda.validation;

import com.sda.dto.StudentDto;
import com.sda.model.Student;
import org.springframework.stereotype.Component;

/**
 * Created by Halip on 12.10.2019.
 */
@Component
public class StudentValidation {

    public boolean isNameValid(String name){
        if(name == null)
            return false;
        if(name.length() == 0)
            return false;
        if(!name.matches("([A-Z a-z 1-9])*"))
            return false;
        return true;
    }

    public boolean isAgeValid(int age){
        if(age == 0)
            return false;
        if(age < 18 || age >100)
            return false;
        return true;
    }

    public boolean isDtoValid(StudentDto studentDto){
        if (isNameValid(studentDto.getName())
                && isAgeValid(studentDto.getAge()))
            return true;
        return false;
    }

    public boolean isStudentValid(Student student){
        if(isNameValid(student.getName()))
            return true;
        return false;
    }
}
