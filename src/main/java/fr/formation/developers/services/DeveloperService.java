package fr.formation.developers.services;

import fr.formation.developers.domain.dtos.DeveloperCreate;
import fr.formation.developers.domain.dtos.DeveloperUpdate;
import fr.formation.developers.domain.dtos.DeveloperView;

public interface DeveloperService {
    DeveloperView getByNickname(String nickname);
    void createDeveloper(DeveloperCreate developer);
    void updateBirthdate(String nickname, DeveloperUpdate update);
}
