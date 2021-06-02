package fr.formation.developers.domain.dtos;

import javax.validation.constraints.FutureOrPresent;
import java.time.LocalDate;

public class ProjectClose {
    @FutureOrPresent
    private LocalDate endDate;

    public ProjectClose() {}

    public ProjectClose(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
