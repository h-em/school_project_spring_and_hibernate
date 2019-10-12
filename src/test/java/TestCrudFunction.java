import com.sda.entryPoints.EntryPoints;
import com.sda.model.Student;
import org.junit.After;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertTrue;

/**
 * Created by Halip on 06.10.2019.
 */

public class TestCrudFunction {

    @Test
    public void testInsertStudentMethod(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DependencyConfig.class);
        EntryPoints entryPoints = applicationContext.getBean(EntryPoints.class);
        Student student = new Student();
        student.setName("testStudent");
        student.setAge(16);

        //assertTrue(entryPoints.getStudentService().insertStudent(student));
    }

    @After
    public void restoreDb(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DependencyConfig.class);
        EntryPoints entryPoints = applicationContext.getBean(EntryPoints.class);
        entryPoints.getStudentService().deleteStudentByName("testStudent");
    }

}
