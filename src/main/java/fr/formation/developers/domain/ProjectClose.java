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

    public LocalDate getEndDate() {
        return endDate;
    }

/*    TODO - est-ce que on garde les setters and getters qu'on n'a pas utilisé dans le code
    parce que il le faut selon la convention JavaBean ou on peut s'en débarrasser?*/
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
