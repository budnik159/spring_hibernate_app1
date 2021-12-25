package ru.budnik.university_app1.util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.budnik.university_app1.entity.Group;
import ru.budnik.university_app1.entity.Student;
import java.util.Date;
import java.util.List;

public class Util {

    public static Configuration getConfiguration(){
        return new Configuration().configure("hibernate.cfg.xml");
    }

    //Возвращает список всех студентов указанной группы
    public static List<Student> getStudentListFromGroup(String groupName){
       Configuration configuration = getConfiguration();
        SessionFactory factory = configuration.addAnnotatedClass(Student.class)
                .addAnnotatedClass(Group.class).buildSessionFactory();

        Session session = null;
        List<Student> studentList = null;
        List<Group> groupList = null;

        try{
            session = factory.getCurrentSession();
            session.beginTransaction();
            groupList = session.createQuery("from Group where groupName='"+groupName+"'")
                    .getResultList();
            if(!groupList.isEmpty())
                studentList = groupList.get(0).getStudents();

            session.getTransaction().commit();
            System.out.println("DONE!");

        }finally {
            session.close();
            factory.close();
        }
        return studentList;
    }

    // Удаляет студента из группы
    public static void deleteStudentFromGroup(String id){
        Configuration configuration = getConfiguration();
        SessionFactory factory = configuration.addAnnotatedClass(Student.class)
                .addAnnotatedClass(Group.class).buildSessionFactory();
        Student student = null;
        Session session = null;

        try{
            session = factory.getCurrentSession();
            session.beginTransaction();
            student = session.get(Student.class, Integer.parseInt(id));
            session.delete(student);

        }finally {
            session.getTransaction().commit();
            factory.close();
        }
    }

    public static void addNewStudent(String surnameAndName, String groupName){
        Configuration configuration = getConfiguration();
        SessionFactory factory = configuration.addAnnotatedClass(Student.class)
                .addAnnotatedClass(Group.class).buildSessionFactory();

        Session session = null;

        try{
            session = factory.getCurrentSession();
            session.beginTransaction();
            surnameAndName = surnameAndName.trim();
            String[] studentInfo = surnameAndName.split(" ", 2);
            String studentSurname = studentInfo[0];
            String studentName = studentInfo[1].trim();
            Date currentDate = new Date();
            Student student = new Student(studentName, studentSurname, currentDate);
            List<Group> groups = session.createQuery("from Group where groupName='"+groupName+"'").getResultList();
            Group group = groups.get(0);
            group.addStudent(student);
            session.persist(group);
            session.getTransaction().commit();

        }finally {
            session.close();
            factory.close();
        }

    }

    //Показать все группы универститета
    public static List<Group> getAllGroups(){
        Configuration configuration = getConfiguration();
        SessionFactory factory = configuration.addAnnotatedClass(Group.class)
                .addAnnotatedClass(Student.class).buildSessionFactory();
        Session session = null;
        List<Group> groupList = null;
        try{
            session = factory.getCurrentSession();
            session.beginTransaction();

            groupList = session.createQuery("from Group ").getResultList();

            session.getTransaction().commit();

        }finally {
            session.close();
            factory.close();
        }

        return groupList;
    }

    // Добавление новой группы
    public static void addNewGroup(String groupName){
        Configuration configuration = getConfiguration();
        SessionFactory factory = configuration.addAnnotatedClass(Group.class)
                .addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = null;

        try{
            session = factory.getCurrentSession();
            session.beginTransaction();

            Group newGroup = new Group(groupName);
            session.save(newGroup);

            session.getTransaction().commit();

        }finally{
            session.close();
            factory.close();
        }

    }
}
