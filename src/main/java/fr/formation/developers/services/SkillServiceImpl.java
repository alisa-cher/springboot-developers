package fr.formation.developers.services;

import fr.formation.developers.domain.dtos.SkillCreate;
import fr.formation.developers.domain.dtos.SkillView;
import org.springframework.stereotype.Service;

@Service
public class SkillServiceImpl implements SkillService {
    @Override
    public SkillView getById(Long id) {
        System.out.println("call in service");
        SkillView skillView = new SkillView();
        skillView.setName("Spring boot " + id);
        return skillView;
    }

    @Override
    public void create(SkillCreate skill) {
        System.out.println(skill);
    }
}
