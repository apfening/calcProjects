package ru.nau.calcProjects.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;
import java.util.Date;
@Entity
@Getter
@Setter
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String comment;

    private Date creationDate;

    public Client() {
        this.creationDate = new Date();
    }

    public Client(String title){
        this.title = title;
        this.creationDate = new Date();
    }
}
