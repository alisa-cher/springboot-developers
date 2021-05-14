package fr.formation.developers.validation;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.Period;

public class IsAdultValidator implements ConstraintValidator<IsAdult, LocalDate> {
    private final byte ADULT_AGE = 18;

    @Override
    public boolean isValid(LocalDate birthdayDate, ConstraintValidatorContext constraintValidatorContext) {
        if (birthdayDate == null) {
            return true;
        }

        LocalDate now = LocalDate.now();
        Period period = Period.between(birthdayDate, now);
        if (period.getYears() < 0) {
            return true;
        }
        System.out.println("Birthday: " + birthdayDate);
        System.out.println("LocalDate: " + now);
        System.out.println("Years: " + period.getYears());
        return (period.getYears() >= ADULT_AGE);
    }
}
