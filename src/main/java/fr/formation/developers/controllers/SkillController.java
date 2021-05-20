package fr.formation.developers.controllers;
import fr.formation.developers.domain.dtos.SkillCreate;

import fr.formation.developers.domain.dtos.SkillView;
import fr.formation.developers.services.SkillService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@RestController
public class SkillController {

    //@Autowired //JEE = @Inject
    private final SkillService service;

    public SkillController(SkillService service) {
        this.service = service;
    }

    @GetMapping("/skills/{id}")
    public SkillView getById(@PathVariable("id") Long id) {
        System.out.println("call in controller");
        return service.getById(id);
    }

    @GetMapping("/skills/{name}/by-name")
    public SkillView getByName(@PathVariable("name") String name) {
        return service.getByName(name);
    }

    @PostMapping("/skills")
    public void create(@Valid @RequestBody SkillCreate dto) {
        service.create(dto);
    }
}
