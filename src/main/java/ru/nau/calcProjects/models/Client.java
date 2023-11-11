package ru.nau.calcProjects.models;

import jakarta.persistence.*;

import java.util.Calendar;
import java.util.Date;
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Date creationDate;

    public Client(String title){
        this.title = title;
        this.creationDate = new Date();
    }

    public Long getId() {
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
