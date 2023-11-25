package ru.nau.calcProjects.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.nau.calcProjects.exception.PriceNotFoundException;
import ru.nau.calcProjects.models.Price;
import ru.nau.calcProjects.services.PriceService;

import java.util.List;

@RestController
public class PriceRestController {

    private final PriceService priceService;

    @Autowired
    public PriceRestController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping("/api/price")
    public List<Price> getAllPrices() {
        return priceService.findAll();
    }

    @GetMapping ("/api/price/{id}")
    public Price getPrice(@PathVariable long id) throws PriceNotFoundException {
        return priceService.getById(id);
    }

    @PostMapping("/api/price")
    public Price createPrice(@RequestBody Price price) {
        if (price.getTitle().isEmpty()) {
            throw new RuntimeException("Название прайса не может быть пустым. Необходимо заполнить.");
        } else if (price.getLicpercent() == null) {
            throw new RuntimeException("Процент от стоимости лицензий не может быть пустым. Необходимо заполнить.");
        } else if (price.getWorkpercent() == null) {
            throw new RuntimeException("Процент от стоимости проектных работ не может быть пустым. Необходимо заполнить.");
        } else if (price.getHourcost() == null) {
            throw new RuntimeException("Ставка человеко-часа не может быть пустой. Необходимо заполнить.");
        }
        return priceService.createPrice(price);
    }

    @PutMapping("/api/price/{id}")
    public Price editPrice(@PathVariable("id") long id, @RequestBody Price price) throws PriceNotFoundException {
        if (price.getTitle().isEmpty()) {
            throw new RuntimeException("Название прайса не может быть пустым. Необходимо заполнить.");
        }
        return priceService.editPrice(price, id);
    }

    @DeleteMapping("/api/price/{id}")
    public String deleteBook(@PathVariable("id") long id) throws PriceNotFoundException {
        priceService.deleteById(id);
        return "{\"state\":\"success\"}";
    }
}
