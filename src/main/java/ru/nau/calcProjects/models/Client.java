package ru.nau.calcProjects.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Calendar;
import java.util.Date;
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue
    private static Long id;
    private String title;
    private Date creationDate;

    public Client(String title){
        this.title = title;
        this.creationDate = new Date();
    }

    public static Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreationDate(Client client) {
        return creationDate;
    }
}
