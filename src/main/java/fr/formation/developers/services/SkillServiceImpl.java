package fr.formation.developers.services;

import fr.formation.developers.domain.dtos.SkillCreate;
import fr.formation.developers.domain.dtos.SkillView;
import fr.formation.developers.domain.entities.Skill;
import fr.formation.developers.repositories.SkillRepository;
import org.springframework.stereotype.Service;

@Service
public class SkillServiceImpl implements SkillService {
    private final SkillRepository repository;

    public SkillServiceImpl(SkillRepository repository) {
        this.repository = repository;
    }

    @Override
    public SkillView getById(Long id) {
        Skill skill = repository.findById(id).get();
        SkillView view = new SkillView();
        view.setName(skill.getName());
        return view;
    }

    @Override
    public SkillView getByName(String name) {
        Skill skill = repository.findByName(name).get();
        SkillView view = new SkillView();
        view.setName(skill.getName());
        return view;
    }

    @Override
    public void create(SkillCreate dto) {
        Skill skill = new Skill();
        skill.setName(dto.getName());
        // - sauvegarder skill en base de donnees
        repository.save(skill);
        System.out.println(dto);
    }
}
