package ru.nau.calcProjects.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nau.calcProjects.models.Client;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> getByTitle(String title);
}
