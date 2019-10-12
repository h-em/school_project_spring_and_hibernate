package com.sda.dao;

import com.sda.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class GenericDao<T> {

    public boolean createEntity(T entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(entity);
        transaction.commit();
        session.close();

        if(entity==null)
            return false;
        return true;
    }

    public T getEntityById(Class<T> cls, int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        T entity = session.get(cls, id);

        transaction.commit();
        //session.close();
        return entity;
    }


    public T updateEntity(T entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        T entityToReturn = (T) session.merge(entity);

        transaction.commit();
        session.close();
        return entityToReturn;
    }


}
