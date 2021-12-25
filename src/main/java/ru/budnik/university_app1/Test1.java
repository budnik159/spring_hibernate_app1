package ru.budnik.university_app1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.budnik.university_app1.entity.*;

import java.util.Date;

public class Test1 {
    public static void main(String[] args) {
        System.out.println("Start");
        System.out.println("--------------------------------------------------------------------");

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).addAnnotatedClass(Group.class)
                .buildSessionFactory();


        Session session = null;
        try{
            session = factory.getCurrentSession();
            session.beginTransaction();
            Student newStudent = new Student("Малкова", "Татьяна", new Date());
            Group group = new Group("Cookies");

            group.addStudent(newStudent);

            session.save(group);
            session.save(newStudent);


            for (Student student : group.getStudents()) {
                System.out.println(student);
            }


            session.getTransaction().commit();

            System.out.println("--------------------------------------------------------------------");
            System.out.println("DONE");

        }finally {
            session.close();
            factory.close();
        }


      /*  SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).buildSessionFactory();
        Session session = null;

        try{
            session = factory.getCurrentSession();
            session.beginTransaction();
            Student student = session.get(Student.class, 1);
            System.out.println("DONE!");


        }finally {
            session.getTransaction().commit();
            factory.close();
        }*/

    }
}
