package com.sda.dao;

import com.sda.model.Student;
import com.sda.model.Teacher;
import com.sda.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Halip on 06.10.2019.
 */
@Repository
public class TeacherDao extends GenericDao<Teacher>{


    public List<Student> getTeacherList(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Student> elementsList = new ArrayList<Student>();
        try {
            String sql = "from Teacher ";
            Query query = session.createQuery(sql);
            elementsList = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }

        transaction.commit();
        session.close();
        return elementsList;
    }

    public boolean deleteEntity(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        boolean validator = false;

        try {
            Teacher teacher = getEntityById(Teacher.class,id);
            if (teacher!=null){
                session.delete(teacher);
                validator = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        transaction.commit();
        session.close();
        return validator;
    }

    public void deleteEntityByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {

            String hql = "delete from Teacher s where s.name = :name";
            Query query = session.createQuery(hql)
                    .setParameter("name",name);
            query.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        transaction.commit();
        session.close();
    }
}
