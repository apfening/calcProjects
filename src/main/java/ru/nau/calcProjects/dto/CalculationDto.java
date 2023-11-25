package ru.nau.calcProjects.dto;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.nau.calcProjects.models.Calculation;
import ru.nau.calcProjects.models.Client;
import ru.nau.calcProjects.models.Price;
import ru.nau.calcProjects.models.User;

import java.util.Date;

@NoArgsConstructor
@Data
public class CalculationDto {
    private Long id;
    private String author;
    private String client;
    private String price;
    private Date creationDate;
    private Double licCost;
    private Double workCost;
    private Integer hours;
    private Double resultCalculation;

    public CalculationDto(Calculation calculation) {
        this.id = calculation.getId();
        this.author = calculation.getAuthor().getUsername();
        this.client = calculation.getClient().getTitle();
        this.price = calculation.getPrice().getTitle();
        this.creationDate = calculation.getCreationDate();
        this.licCost = calculation.getLicCost();
        this.workCost = calculation.getWorkCost();
        this.hours = calculation.getHours();
        this.resultCalculation = calculation.getResultCalculation();
    }
}
