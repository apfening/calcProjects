package ru.nau.calcProjects.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.nau.calcProjects.models.Price;
import ru.nau.calcProjects.repositories.PriceRepository;

@Component
@Service
public class PriceService {
    protected final PriceRepository priceRepository;

    @Autowired
    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    void savePrice(String title, double licePercent, double workPersent, double hourCost) {
        try {
            Price price = new Price(title);
            price.setLicpercent(licePercent);
            price.setWorkpercent(workPersent);
            price.setHourcost(hourCost);
            priceRepository.save(price);
        } catch (Exception e) {
            if (title.isEmpty()) {
                throw new RuntimeException("Название прайса не может быть пустым. Необходимо заполнить.");
            }
        }
    }
}
