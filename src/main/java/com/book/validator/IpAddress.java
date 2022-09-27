package com.book.validator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;
import java.util.List;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = {IpAddressImpl.class}
)
public @interface IpAddress {

    String message() default "{validation.constraints.ip-address.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
