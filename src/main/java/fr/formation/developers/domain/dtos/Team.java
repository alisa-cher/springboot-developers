package fr.formation.developers.domain.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Team {
    @NotBlank
    @NotNull
    @Size(min = 1, max = 255)
    private String name;

    @NotNull
    private Boolean isAgile;

    public Team() {}

    public Team(String name, Boolean isAgile) {
        this.name = name;
        this.isAgile = isAgile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getAgile() {
        return isAgile;
    }

    public void setAgile(Boolean agile) {
        this.isAgile = agile;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", isAgile=" + isAgile +
                '}';
    }
}
