package fr.formation.developers.repositories;
import fr.formation.developers.domain.dtos.IDeveloperView;
import fr.formation.developers.domain.entities.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeveloperRepository extends JpaRepository<Developer, Long> {
    Optional<Developer> findByNickname(String name);
    Optional<IDeveloperView> findByFirstNameAndLastName(String firstName, String lastName);
}

