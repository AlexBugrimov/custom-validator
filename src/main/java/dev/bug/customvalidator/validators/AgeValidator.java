package dev.bug.customvalidator.validators;

import dev.bug.customvalidator.ValidAge;
import dev.bug.customvalidator.entity.User;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.Period;

public class AgeValidator implements ConstraintValidator<ValidAge, User> {

    private int minAge;

    @Override
    public void initialize(ValidAge constraintAnnotation) {
        this.minAge = constraintAnnotation.minAge();
    }

    @Override
    public boolean isValid(User user, ConstraintValidatorContext context) {
        var now = LocalDate.now();
        var birthday = user.getBirthday();
        var years = Period.between(birthday, now).getYears();
        return years >= minAge;
    }
}
