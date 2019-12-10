package club.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CValidarFecha.class)
@Target({ ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)

public @interface ValidarFecha {
	String message() default"La fecha ha de ser igual en formato DD/MM/AAAA y no anterior a hoy ";
	Class<?>[] groups() default{};
	Class<? extends Payload>[] payload() default{};
}
