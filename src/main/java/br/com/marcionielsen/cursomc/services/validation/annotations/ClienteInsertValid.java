package br.com.marcionielsen.cursomc.services.validation.annotations;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.com.marcionielsen.cursomc.services.validation.validators.ClienteInsertValidator;

@Constraint(validatedBy=ClienteInsertValidator.class)
@Retention(RUNTIME)
@Target(TYPE)
public @interface ClienteInsertValid {
	String message() default "";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload	>[] payload() default {};
	
}
