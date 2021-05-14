package fr.formation.developers.domain;

import fr.formation.developers.validation.IsNotIdentical;

import javax.validation.constraints.*;
import java.time.LocalDate;

@IsNotIdentical
public class ProjectCreate {
    private static final int NAME_MAX_LENGTH = 255;
    private static final int DESCRIPTION_MAX_LENGTH = 1000;

    @NotNull
    @NotBlank
    @Size(max = NAME_MAX_LENGTH)
    private String name;

    @NotNull
    @NotBlank
    @Size(max = DESCRIPTION_MAX_LENGTH)
    private String description;

    @NotNull
    @FutureOrPresent
    private LocalDate startDate;

    @Positive
    private Integer budget;

    public ProjectCreate() {}

    public ProjectCreate(String name, String description, LocalDate startDate) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
    }

    public ProjectCreate(String name, String description, LocalDate startDate, Integer budget) {
        this(name, description, startDate);
        this.budget = budget;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "ProjectCreate{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", budget=" + budget +
                '}';
    }
}
