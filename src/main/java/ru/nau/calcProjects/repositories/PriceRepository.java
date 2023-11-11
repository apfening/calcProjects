package ru.nau.calcProjects.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nau.calcProjects.models.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
//    Price findByLastCreationDate();
}
