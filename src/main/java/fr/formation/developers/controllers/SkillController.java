package fr.formation.developers.controllers;

import fr.formation.developers.domain.Skill;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@RestController
public class SkillController {
    @GetMapping("/skills/{id}")
    public Skill getById(@PathVariable("id") Long id) {
        Skill skill = new Skill();
        skill.setName("Spring boot " + id);
        return skill;
    }

    @PostMapping("/skills")
    public void create(@Valid @RequestBody Skill skill) {
        System.out.println(skill);
    }
}
