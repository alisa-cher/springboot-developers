package fr.formation.developers.controllers;
import fr.formation.developers.domain.Team;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {

    public List<Team> repository = new ArrayList<>();

    public TeamController() {
        Team team1 = new Team("bestTeam", true);
        Team team2 = new Team("worstTeam", false);

        repository.add(team1);
        repository.add(team2);
    }

    @PostMapping
    public Team createTeam(@Valid @RequestBody Team team) {
        repository.add(team);
        System.out.println("You've successfully created team " + team.getName());
        System.out.println(team);
        return team;
    }

    @DeleteMapping("/{name}")
    public void deleteTeam(@PathVariable("name") String name) {
        int index = -1;

        for(Team team : repository) {
            if(team.getName().equals(name)) {
                index = repository.indexOf(team);
            }
        }
        if (index != -1) {
            repository.remove(index);
        } else {
            System.out.println("You can't remove this team as it doesn't exist.");
        }
        System.out.println("You've successfully deleted team " + name);
        System.out.println(repository);
    }
}