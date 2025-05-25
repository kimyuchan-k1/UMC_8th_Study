package umc.spring.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.spring.validation.validator.NotAlreadyChallengingValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotAlreadyChallengingValidator.class)
public @interface NotAlreadyChallenging {
    String message() default "CHALLENGING_ALREADY";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
