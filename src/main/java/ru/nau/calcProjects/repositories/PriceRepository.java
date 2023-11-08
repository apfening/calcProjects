package ru.nau.calcProjects.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.nau.calcProjects.models.Price;

@Repository
public interface PriceRepository extends CrudRepository<Price, Long> {
    Price findByLastCreationDate();
}
