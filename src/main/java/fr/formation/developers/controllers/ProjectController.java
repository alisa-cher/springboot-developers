package fr.formation.developers.controllers;

import fr.formation.developers.domain.dtos.ProjectClose;
import fr.formation.developers.domain.dtos.ProjectCreate;
import fr.formation.developers.domain.dtos.ProjectUpdate;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    public List<ProjectCreate> projectRepository = new ArrayList<>();

    private void createMockedData() {
        ProjectCreate project1 = new ProjectCreate("project1", "interesting project", LocalDate.of(2021, 10, 12), 2000);
        ProjectCreate project2 = new ProjectCreate("project2", "interesting project", LocalDate.of(2021, 11, 7), 1000);
        projectRepository.add(project1);
        projectRepository.add(project2);
    }

    public ProjectController() {
        this.createMockedData();
    }

    @PostMapping
    public void createTeam(@RequestBody @Valid ProjectCreate project) {
        projectRepository.add(project);
        System.out.println("You've successfully created project " + project.getName());
        System.out.println(project);
    }

    @PatchMapping("/{name}/update")
    public void updateProject(
            @PathVariable("name") String name,
            @RequestBody @Valid ProjectUpdate partial)
    {
        for(ProjectCreate item : projectRepository) {
            if (item.getName().equals(name)) {
                String description = partial.getDescription();
                Integer budget = partial.getBudget();
                item.setDescription(description);
                if (budget != null) {
                    item.setBudget(budget);
                }
                System.out.println(item);
            }
        }
    }

    @PatchMapping("/{name}/close")
    public void closeProject(
            @PathVariable("name") String name,
            @RequestBody @Valid ProjectClose partial)
    {
        for(ProjectCreate item : projectRepository) {
            if (item.getName().equals(name)) {
                item.setEndDate(partial.getEndDate());
                System.out.println(item);
            }
        }
    }
}

