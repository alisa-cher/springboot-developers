package fr.formation.developers.controllers;

import fr.formation.developers.domain.Developer;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/developers")
public class DeveloperController {

    public List<Developer> repository = new ArrayList<>();

    public List<Developer> createMockedDevelopers() {

        Developer dev1 = new Developer("Dev1", "Prenom1", "Nom1", LocalDate.of(1978,12, 13));
        Developer dev2 = new Developer("Dev2", "Prenom2", "Nom2", LocalDate.of(1948,11, 13));

        repository.add(dev1);
        repository.add(dev2);

        return repository;
    }

    @GetMapping
    public List<Developer> getDevelopersList() {
        return this.createMockedDevelopers();
    }

    @GetMapping("/{nickname}")
    public Developer getByNickname(@PathVariable String nickname) {
        for (Developer developer : repository) {
            if(developer.getNickname().equals(nickname)) {
                return developer;
            }
        }
        return null;
    }

    @PostMapping
    public Developer createDeveloper(@RequestBody Developer developer){
         repository.add(developer);
         return developer;
    }

    @PatchMapping("/{nickname}")
        public void updateBirthdate(
                @PathVariable("nickname") String nickname,
                @RequestBody @Valid Developer partial)
        {
            for(Developer item : repository) {
                if (item.getNickname().equals(nickname)) {
                    item.setBirthdate(partial.getBirthdate());
               }
        }
    }
}

