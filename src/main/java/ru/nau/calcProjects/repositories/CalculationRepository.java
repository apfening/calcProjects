package ru.nau.calcProjects.repositories;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.nau.calcProjects.models.Calculation;

import java.util.List;

public interface CalculationRepository extends JpaRepository<Calculation, Long> {

//    List<Calculation> findAllByClientId(Sort sort);
//    List<Calculation> findAllByAuthorId(Sort sort);
}
