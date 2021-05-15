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

    private final List<DeveloperCreate> developersRepository = new ArrayList<>();

    private void createMockedData() {
        DeveloperCreate dev1 = new DeveloperCreate("Dev1", "Prenom1", "Nom1", LocalDate.of(1978,12, 13));
        DeveloperCreate dev2 = new DeveloperCreate("Dev2", "Prenom2", "Nom2", LocalDate.of(1948,11, 13));

        developersRepository.add(dev1);
        developersRepository.add(dev2);
    }

    public DeveloperController() {
        this.createMockedData();
    }

    @GetMapping("/{nickname}")
    public DeveloperCreate getByNickname(@PathVariable String nickname) {
        for (DeveloperCreate developer : developersRepository) {
            if(developer.getNickname().equals(nickname)) {
                return developer;
            }
        }
        return null;
    }

    @PostMapping
    public void createDeveloper(@RequestBody @Valid DeveloperCreate developer){
         developersRepository.add(developer);
         System.out.println(developer);
    }

    @PatchMapping("/{nickname}")
        public void updateBirthdate(
                @PathVariable("nickname") String nickname,
                @RequestBody @Valid DeveloperUpdate partial)
        {
            for(DeveloperCreate item : developersRepository) {
                if (item.getNickname().equals(nickname)) {
                   item.setBirthdate(partial.getBirthdate());
               }
            }
        }
}

