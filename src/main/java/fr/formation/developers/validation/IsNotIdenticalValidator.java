package fr.formation.developers.validation;

import fr.formation.developers.domain.dtos.ProjectCreate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsNotIdenticalValidator implements ConstraintValidator<IsNotIdentical, ProjectCreate> {

    @Override
    public boolean isValid(ProjectCreate projectCreate, ConstraintValidatorContext constraintValidatorContext) {
        String projectName = projectCreate.getName();
        String projectDescription = projectCreate.getDescription();
        return !projectName.equals(projectDescription);
    }
}
