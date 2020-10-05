package ru.Aidar.SQL.hibernate.models;

import javax.persistence.*;

@Entity
@Table(name = "part2.user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_cont;// идентификатор абонента
    private String first_name;//имя
    private String middle_name;// отчество
    private String last_name;//фамилия
    private int id_gender;//идентификатор пола 1-м, 2-ж

    public User(int id_cont, String first_name, String middle_name, String last_name, int id_gender) {
        this.id_cont = id_cont;
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.id_gender = id_gender;
    }

    public User( String first_name, String middle_name, String last_name, int id_gender) {
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.id_gender = id_gender;
    }

    public User() {
    }


    public int getId_cont() {
        return id_cont;
    }

    public void setId_cont(int id_cont) {
        this.id_cont = id_cont;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getId_gender() {
        return id_gender;
    }

    public void setId_gender(int id_gender) {
        this.id_gender = id_gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "id_cont=" + id_cont +
                ", first_name='" + first_name + '\'' +
                ", middle_name='" + middle_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", id_gender=" + id_gender +
                '}';
    }
}
