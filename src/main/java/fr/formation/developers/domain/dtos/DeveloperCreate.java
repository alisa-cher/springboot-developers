package fr.formation.developers.domain.dtos;
import fr.formation.developers.validation.IsAdult;

import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

public class DeveloperCreate {
    @NotNull
    private String nickname;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @Past
    @NotNull
    @IsAdult
    private LocalDate birthdate;

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public DeveloperCreate() {}

    public DeveloperCreate(String nickname, String firstName, String lastName, LocalDate birthdate) {
        this.birthdate = birthdate;
        this.nickname = nickname;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "DeveloperCreate{" +
                "nickname='" + nickname + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}
