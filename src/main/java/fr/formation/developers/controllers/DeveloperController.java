package fr.formation.developers.controllers;

import fr.formation.developers.domain.dtos.IDeveloperView;
import fr.formation.developers.domain.dtos.DeveloperUpdate;
import fr.formation.developers.domain.dtos.DeveloperView;
import fr.formation.developers.domain.dtos.DeveloperCreate;
import fr.formation.developers.services.DeveloperService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/developers")
public class DeveloperController {

    private final DeveloperService service;

    public DeveloperController(DeveloperService service) {
        this.service = service;
    }

    @GetMapping("/{nickname}")
    public DeveloperView getByNickname(@PathVariable String nickname) {
        return service.getByNickname(nickname);
    }

    @PostMapping
    public void createDeveloper(@RequestBody @Valid DeveloperCreate dto){
        service.createDeveloper(dto);
    }

    @PatchMapping("/{nickname}")
        public void updateBirthdate(
                @PathVariable("nickname") String nickname,
                @RequestBody @Valid DeveloperUpdate dto)
        {
            service.updateBirthdate(nickname, dto);
        }

    @GetMapping("/find")
    public IDeveloperView find() {
        return service.find();
    }
}

