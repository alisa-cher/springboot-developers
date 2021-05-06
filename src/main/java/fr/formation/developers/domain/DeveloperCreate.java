package fr.formation.developers.domain;
import java.time.LocalDate;
import javax.validation.constraints.NotNull;

public class DeveloperCreate extends DeveloperUpdate {
    @NotNull
    private String nickname;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    public DeveloperCreate() {}

    public DeveloperCreate(String nickname, String firstName, String lastName, LocalDate birthdate) {
        super(birthdate);
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
                ", birthdate=" + super.getBirthdate() +
                '}';
    }
}
