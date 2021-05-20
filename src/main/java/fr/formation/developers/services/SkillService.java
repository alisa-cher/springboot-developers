package fr.formation.developers.services;

import fr.formation.developers.domain.dtos.SkillCreate;
import fr.formation.developers.domain.dtos.SkillView;

public interface SkillService {
    SkillView getById(Long id);
    SkillView getByName(String name);
    void create(SkillCreate dto);
}
