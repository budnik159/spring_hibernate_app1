package ru.budnik.university_app1.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "university_group")
public class Group {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "group_name")
    private String groupName;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE},
            mappedBy = "universityGroup", fetch = FetchType.EAGER)
    private List<Student> students;

    public Group() {

    }

    public Group(String groupName) {

        this.groupName = groupName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Student> getStudents() {
        return students;
    }
/*
    public void setStudents(List<Student> students) {
        this.students = students;
    }*/

    public void addStudent(Student student){
        if(students == null){
            students = new ArrayList<Student>();
        }

        students.add(student);
        student.setUniversityGroup(this);


    }
}


