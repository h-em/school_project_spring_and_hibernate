import com.sda.dto.StudentDto;
import com.sda.dto.TeacherDto;
import com.sda.entryPoints.EntryPoints;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class Main {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DependencyConfig.class);
        EntryPoints entryPoints = applicationContext.getBean(EntryPoints.class);
        //entryPoints.execute();


        StudentDto studentDto = new StudentDto();
        studentDto.setName("Alta ana 2");
        studentDto.setAge(20);
        //entryPoints.executeStudentDto(studentDto);

        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setName("Teacher");
        teacherDto.setJob("prof roamana");
        teacherDto.setAge(55);
       // entryPoints.executeTeacherDto(teacherDto);

        for(StudentDto eachStudentDto : entryPoints.displayStudents()){
            System.out.println(eachStudentDto);
        }

        /*
        StudentService studentService = new StudentService();

        List<Student> studentList = entryPoints.getStudentService().getStudentList();

        for(Student student : studentList){
            System.out.println(student.getName());
        }
        */

        //entryPoints.getStudentService().deleteStudentByName("testStudent");


    }
}
