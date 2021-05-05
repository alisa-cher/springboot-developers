package fr.formation.developers.domain;
import java.time.LocalDate;
import javax.validation.constraints.NotNull;

public class Developer {
    private String nickname;
    private String firstName;
    private String lastName;
    @NotNull
    private LocalDate birthdate;

    public Developer() {}

    public Developer(String nickname, String firstName, String lastName, LocalDate birthdate) {
        this.nickname = nickname;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
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

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "Developer [" +
                "nickname=" + nickname + ", " +
                "firstName=" + firstName + ", " +
                "lastName=" + lastName + ", " +
                "birthdate=" + birthdate +
                "]";
    }
}
