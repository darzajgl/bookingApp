//package com.example.roombookingapp.booking.common;
//
//import com.example.roombookingapp.booking.guest.Guest;
//import com.example.roombookingapp.booking.room.Room;
//import org.hibernate.SessionFactory;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.cfg.Environment;
//import org.hibernate.service.ServiceRegistry;
//
//import java.util.Properties;
//
//public class HibernateConfiguration {
//    private static SessionFactory sessionFactory;
//
//    public static SessionFactory getSessionFactory() {
//        if (sessionFactory == null) {
//            try {
//                Configuration configuration = new Configuration();
//                Properties settings = new Properties();
//
//                settings.put(Environment.DRIVER, "org.postgresql.Driver");
//                settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/booking_db");
//                settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
//                settings.put(Environment.SHOW_SQL, "true");
//                settings.put(Environment.USER, "postgres");
//                settings.put(Environment.PASS, "postgres");
//                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
//                settings.put(Environment.HBM2DDL_AUTO, "create");
//
//                configuration.setProperties(settings);
//                configuration.addAnnotatedClass(Room.class);
//                configuration.addAnnotatedClass(Guest.class);
//                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
//                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return sessionFactory;
//    }
//}
