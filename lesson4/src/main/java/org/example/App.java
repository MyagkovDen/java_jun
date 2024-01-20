package org.example;

import org.example.config.DatabaseConnector;
import org.example.entity.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        DatabaseManager dbManager = new DatabaseManager(new DatabaseConnector());
        dbManager.createTable();

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Course maths = new Course("Mathematics", 192);
            Course law = new Course("Law", 168);
            session.save(maths);
            System.out.println("Course " + maths.getTitle() + " successfully added to table");
            session.save(law);
            System.out.println("Course " + law.getTitle() + " successfully added to table");
            session.getTransaction().commit();
        }

        try(Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();
            Course course = session.get(Course.class, 1);
            session.getTransaction().commit();
            System.out.println("Course " + course.getTitle() + " retrieved successfully");
            System.out.println("Retrieved course: " + course);
        }

        try(Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();
            Course course = session.get(Course.class, 2);
            course.setTitle("History");
            course.setDuration(144);
            session.saveOrUpdate(course);
            session.getTransaction().commit();
            System.out.println("Course " + course + " successfully updated");
        }

        try(Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();
            Course course = session.get(Course.class, 1);
            session.delete(course);
            session.getTransaction().commit();
            System.out.println("Course " + course + " successfully deleted");
        }

    }
}
