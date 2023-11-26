package ru.nau.calcProjects.services;

import ru.nau.calcProjects.dto.CalculationDto;
import ru.nau.calcProjects.exception.CalculationNotFoundException;
import ru.nau.calcProjects.models.Calculation;

import java.util.List;

public interface CalculationService {
    Calculation createCalculation(CalculationDto calculation);

    List<Calculation> findAll();

    List<Calculation> findAllByClientId(Long clientId);

    Calculation findById(Long id) throws CalculationNotFoundException;

    void deleteById(Long id) throws CalculationNotFoundException;
}
