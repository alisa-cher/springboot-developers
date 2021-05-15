package fr.formation.developers.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class ProjectUpdate {
    private static final int DESCRIPTION_MAX_LENGTH = 1000;

    @NotNull
    @NotBlank
    @Size(max = DESCRIPTION_MAX_LENGTH)
    private String description;

    @Positive
    private Integer budget;

    public ProjectUpdate() {}

    public ProjectUpdate(String description) {
        this.description = description;
    }

    public ProjectUpdate(Integer budget, String description) {
        this(description);
        this.budget = budget;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "ProjectUpdate{" +
                "description='" + description + '\'' +
                ", budget=" + budget +
                '}';
    }
}
