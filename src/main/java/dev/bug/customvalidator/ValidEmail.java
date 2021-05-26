package dev.bug.customvalidator;

import dev.bug.customvalidator.validators.AgeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AgeValidator.class)
public @interface ValidEmail {

    String message() default "Error in email";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
