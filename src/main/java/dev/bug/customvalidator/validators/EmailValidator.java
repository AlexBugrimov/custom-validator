package dev.bug.customvalidator.validators;

import dev.bug.customvalidator.ValidEmail;
import dev.bug.customvalidator.entity.User;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class EmailValidator implements ConstraintValidator<ValidEmail, User> {

    private static final String EMAIL_PATTERN = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

    @Override
    public void initialize(ValidEmail constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(User user, ConstraintValidatorContext constraintValidatorContext) {
        return validateEmail(user.getEmail());
    }

    private boolean validateEmail(String email) {
        var pattern = Pattern.compile(EMAIL_PATTERN);
        var matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
