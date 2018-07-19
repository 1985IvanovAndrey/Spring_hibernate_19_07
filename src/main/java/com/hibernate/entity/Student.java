package com.hibernate.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "student")
public class Student {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idStud;

    @Column(name="name")
    private String nameStud;
    @Column(name="phone")
    private String phoneStud;

    public int getIdStud() {
        return idStud;
    }

    public void setIdStud(int idStud) {
        this.idStud = idStud;
    }

    public String getNameStud() {
        return nameStud;
    }

    public void setNameStud(String nameStud) {
        this.nameStud = nameStud;
    }

    public String getPhoneStud() {
        return phoneStud;
    }

    public void setPhoneStud(String phoneStud) {
        this.phoneStud = phoneStud;
    }

    @Override
    public String toString() {
        return "Student{" +
                "idStud=" + idStud +
                ", nameStud='" + nameStud + '\'' +
                ", phoneStud='" + phoneStud + '\'' +
                '}';
    }
}

