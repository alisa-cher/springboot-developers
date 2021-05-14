package fr.formation.developers.domain;

import fr.formation.developers.validation.IsAdult;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

public class DeveloperUpdate {
    @Past
    @NotNull
    @IsAdult
    private LocalDate birthdate;

    public DeveloperUpdate() {}

    public DeveloperUpdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "DeveloperUpdate{" +
                "birthdate=" + birthdate +
                '}';
    }
}
