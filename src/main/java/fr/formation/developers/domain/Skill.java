package fr.formation.developers.domain;

import javax.validation.constraints.NotNull;
import fr.formation.developers.validation.Uppercase;

public class Skill {
    @NotNull
    @Uppercase
    private String name;

    public Skill() {}

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
