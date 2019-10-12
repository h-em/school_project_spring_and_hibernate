package com.sda.validation;

import com.sda.dto.TeacherDto;
import org.springframework.stereotype.Component;

/**
 * Created by Halip on 12.10.2019.
 */
@Component
public class TeacherValidator {

    public boolean isJobValid(String job) {
        if (job == null)
            return false;
        if (job.length() == 0)
            return false;
        if (!job.matches("([A-Z a-z])*"))
            return false;
        return true;
    }

    public boolean isAgeValid(int age) {
        if (age == 0)
            return false;
        if (age < 18 || age > 100)
            return false;
        return true;
    }

    public boolean isDtoValid(TeacherDto teacherDto) {
        if (isJobValid(teacherDto.getName())
                && isJobValid(teacherDto.getJob())
                && isAgeValid(teacherDto.getAge())) {
            return true;
        }
        return false;
    }
}
