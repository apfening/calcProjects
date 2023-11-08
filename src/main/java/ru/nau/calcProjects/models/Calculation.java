package ru.nau.calcProjects.models;

import jakarta.persistence.*;
import ru.nau.calcProjects.repositories.PriceRepository;

import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "calculations")
public class Calculation {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private static Long id;
    private User author;
    private Client client;
    private Date creationdate;
    private double liccost;
    private double workcost;
    private int hours;
    private double resultCalculation;

    public Calculation(Client client) {
        this.client = client;
        this.creationdate = new Date();
    }

    private static Long getId() {
        return id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public double getLiccost() {
        return liccost;
    }

    public void setLiccost(double liccost) {
        this.liccost = liccost;
    }

    public double getWorkcost() {
        return workcost;
    }

    public void setWorkcost(double workcost) {
        this.workcost = workcost;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public double getResultCalculation() {
        return resultCalculation;
    }

    public void setResultCalculation(double liccost, double workcost, int hours) {
        //active calcPrice
        Price activePrice = null;
        this.resultCalculation = liccost * activePrice.getLicpercent()
                + workcost * activePrice.getWorkpercent()
                + hours * activePrice.getHourcost();
    }
}
