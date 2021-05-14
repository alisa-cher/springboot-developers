package fr.formation.developers.controllers;

import fr.formation.developers.domain.ProjectCreate;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    public List<ProjectCreate> repository = new ArrayList<>();

    public ProjectController() {
        ProjectCreate project1 = new ProjectCreate("project1", "interesting project", LocalDate.of(2021, 10, 12), 2000);
        ProjectCreate project2 = new ProjectCreate("project2", "interesting project", LocalDate.of(2021, 11, 7), 1000);
        repository.add(project1);
        repository.add(project2);
    }

    @PostMapping
    public ProjectCreate createTeam(@RequestBody @Valid ProjectCreate project) {
        repository.add(project);
        System.out.println("You've successfully created project " + project.getName());
        System.out.println(project);
        return project;
    }

    // TODO - implement a partial update via ProjectUpdate class
    @PatchMapping("/{name}")
    public void updateProject(
            @PathVariable("name") String name,
            // TODO - add @Valid annotation
            @RequestBody ProjectCreate project)
    {
        for(ProjectCreate item : repository) {
            if (item.getName().equals(name)) {
                item.setDescription(project.getDescription());
                item.setBudget(project.getBudget());
            }
        }
        System.out.println(project);
    }
}

