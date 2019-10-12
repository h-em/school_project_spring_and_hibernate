package com.sda.util;


import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {



    private static StandardServiceRegistry standardServiceRegistry;
    private static SessionFactory sessionFactory;
    static {
        try {
            if (sessionFactory == null){
                standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
                MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
                Metadata metadata = metadataSources.getMetadataBuilder().build();
                sessionFactory = metadata.getSessionFactoryBuilder().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (standardServiceRegistry != null){
                StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
            }
        }
    }
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }


    /*
    private static SessionFactory sessionFactory;
    private static StandardServiceRegistry registry;

    private static void initSession(){
        // Create registry
        registry = new StandardServiceRegistryBuilder().configure().build();
        // Create MetadataSources
        MetadataSources sources = new MetadataSources(registry);
        // Create Metadata
        if(sources.getMetadataBuilder()!=null){
            System.out.println("builder not null");
        }
        Metadata metadata = sources.getMetadataBuilder().build();
        // Create SessionFactory
        sessionFactory = metadata.getSessionFactoryBuilder().build();

    }

    public synchronized static SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            initSession();
        }
        return sessionFactory;
    }

    public synchronized static void close(){
        if(sessionFactory != null) {
            sessionFactory.close();
            sessionFactory = null;
            registry.close();
        }
    }
    */
}
