package ru.nau.calcProjects.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "prices")
public class Price {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Date creationDate;

    private Double licpercent;

    private Double workpercent;

    private Double hourcost;

    private boolean status = false;

    public Price() {
        this.creationDate = new Date();
    }

    public Price(String title, Double licpercent, Double workpercent, Double hourcost) {
        this.title = title;
        this.creationDate = new Date();
        this.licpercent = licpercent;
        this.workpercent = workpercent;
        this.hourcost = hourcost;
    }

    public Price(String title) {
        this.title = title;
        this.creationDate = new Date();
    }
}
