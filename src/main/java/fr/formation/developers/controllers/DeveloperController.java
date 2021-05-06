package fr.formation.developers.controllers;

import fr.formation.developers.domain.DeveloperCreate;
import fr.formation.developers.domain.DeveloperUpdate;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/developers")
public class DeveloperController {

    public List<DeveloperCreate> repository = new ArrayList<>();

    public DeveloperController() {

        DeveloperCreate dev1 = new DeveloperCreate("Dev1", "Prenom1", "Nom1", LocalDate.of(1978,12, 13));
        DeveloperCreate dev2 = new DeveloperCreate("Dev2", "Prenom2", "Nom2", LocalDate.of(1948,11, 13));

        repository.add(dev1);
        repository.add(dev2);

    }

    @GetMapping
    public List<DeveloperCreate> list() {
        return repository;
    }

    @GetMapping("/{nickname}")
    public DeveloperCreate getByNickname(@PathVariable String nickname) {
        for (DeveloperCreate developer : repository) {
            if(developer.getNickname().equals(nickname)) {
                return developer;
            }
        }
        return null;
    }

    @PostMapping
    public DeveloperCreate createDeveloper(@RequestBody DeveloperCreate developer){
         repository.add(developer);
         return developer;
    }

    @PatchMapping("/{nickname}")
        public void updateBirthdate(
                @PathVariable("nickname") String nickname,
                @RequestBody @Valid DeveloperUpdate partial)
        {
            System.out.println(partial);
            for(DeveloperCreate item : repository) {
                if (item.getNickname().equals(nickname)) {
                   item.setBirthdate(partial.getBirthdate());
               }
            }
        }
}

