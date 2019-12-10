package club.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CValidarHora.class)
@Target({ ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)

public @interface ValidarHora {
	String message() default"La hora ha de ser en formato HH:MM";
	Class<?>[] groups() default{};
	Class<? extends Payload>[] payload() default{};
}
