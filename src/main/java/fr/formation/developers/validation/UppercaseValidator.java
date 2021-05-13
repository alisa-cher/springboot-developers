package fr.formation.developers.validation;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class UppercaseValidator implements ConstraintValidator<Uppercase, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) {
            return true;
        }
        String uppercased = value.toUpperCase();
        return value.equals(uppercased);
    }
}
