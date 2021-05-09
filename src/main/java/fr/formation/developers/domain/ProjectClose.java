package fr.formation.developers.domain;

import javax.validation.constraints.FutureOrPresent;
import java.time.LocalDate;

public class ProjectClose {
    @FutureOrPresent
    private LocalDate endDate;

    public ProjectClose() {}

    public ProjectClose(LocalDate endDate) {
        this.endDate = endDate;
    }
}
