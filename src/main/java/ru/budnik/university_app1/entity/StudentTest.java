package ru.budnik.university_app1.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "student_test")
public class StudentTest {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "receipt_date")
    private Date receiptDate;


    public StudentTest() {
    }

    public StudentTest(String name, String surname, Date receiptDate) {
        this.name = name;
        this.surname = surname;
        this.receiptDate = receiptDate;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }


    @Override
    public String toString() {
        return "StudentTest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", receiptDate=" + receiptDate +
                '}';
    }
}
