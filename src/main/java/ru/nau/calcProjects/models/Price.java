package ru.nau.calcProjects.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "prices")
public class Price {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Date creationDate;
    private double licpercent;
    private double workpercent;
    private double hourcost;

    public Price(String title) {
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

    public double getLicpercent() {
        return licpercent;
    }

    public void setLicpercent(double licpercent) {
        this.licpercent = licpercent;
    }

    public double getWorkpercent() {
        return workpercent;
    }

    public void setWorkpercent(double workpercent) {
        this.workpercent = workpercent;
    }

    public double getHourcost() {
        return hourcost;
    }

    public void setHourcost(double hourcost) {
        this.hourcost = hourcost;
    }

}
