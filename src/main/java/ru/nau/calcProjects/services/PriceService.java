package ru.nau.calcProjects.services;

import ru.nau.calcProjects.exception.PriceNotFoundException;
import ru.nau.calcProjects.models.Price;

import java.util.List;

public interface PriceService {

    Price createPrice(Price price);
    Price editPrice(Price price, Long id);

    List<Price> findAll();

    Price getById(Long id) throws PriceNotFoundException;

    void deleteById(Long id);
}
