package com.example.moviebooking.config.validator;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = PasswordValidator.class)
public @interface ValidPassword {
    String message() default "the password length must be greater than 8 character";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
