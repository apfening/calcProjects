package ru.nau.calcProjects.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.nau.calcProjects.exception.PriceNotFoundException;
import ru.nau.calcProjects.models.Price;
import ru.nau.calcProjects.repositories.PriceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PriceServiceImpl implements PriceService {
    protected final PriceRepository priceRepository;

    @Autowired
    public PriceServiceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Transactional
    private Price setNewActualPrice(Price price) {
        Optional<Price> actualPriceOptional = priceRepository.findByStatus(true);
        if (actualPriceOptional.isPresent()) {
            Price actualPrice = actualPriceOptional.get();
            actualPrice.setStatus(false);
            priceRepository.save(actualPrice);
        }
        price.setStatus(true);
        return price;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Price> findAll() {
        return priceRepository.findAll(Sort.by(
                Sort.Order.desc("creationDate"),
                Sort.Order.asc("status")
        ));
    }

    @Transactional(readOnly = true)
    @Override
    public Price getById(Long id) throws PriceNotFoundException {
        return priceRepository.findById(id)
                .orElseThrow(() -> new PriceNotFoundException("Прайс под номером " + id + " не найден"));
    }

    @Transactional
    @Override
    public void deleteById(Long id) throws PriceNotFoundException {
        Price deletePrice = getById(id);
        priceRepository.deleteById(id);
        if (deletePrice.isStatus()) {
            Price actualPrice = priceRepository.findFirstByOrderByCreationDateDesc();
            setNewActualPrice(actualPrice);
        }
    }

    @Transactional
    @Override
    public Price createPrice(Price price) {
        Price actualPrice = setNewActualPrice(price);
        return priceRepository.save(actualPrice);
    }

    @Transactional
    @Override
    public Price editPrice(Price price, Long id) throws PriceNotFoundException {
        Price editPrice = getById(id);
        editPrice.setTitle(price.getTitle());
        editPrice.setLicpercent(price.getLicpercent());
        editPrice.setWorkpercent(price.getWorkpercent());
        editPrice.setStatus(price.isStatus());

        if (editPrice.isStatus()) {
            setNewActualPrice(editPrice);
        } else {
            Optional<Price> actualPrice = priceRepository.findByStatus(true);
            if (id.equals(actualPrice.get().getId())) {
                throw new RuntimeException("Невозможно сменить статус данного прайса: должен быть хотя бы один актуальный прайс");
            }
        }
        return priceRepository.save(editPrice);
    }
}
