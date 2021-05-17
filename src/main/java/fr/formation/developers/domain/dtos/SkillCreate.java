package fr.formation.developers.domain.dtos;

import javax.validation.constraints.NotNull;
import fr.formation.developers.validation.Uppercase;

public class SkillCreate {
    @NotNull
    @Uppercase
    private String name;

    public SkillCreate() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Skill [name=" + name + "]";
    }
}
