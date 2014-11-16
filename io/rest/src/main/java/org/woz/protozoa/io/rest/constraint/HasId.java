/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.woz.protozoa.io.rest.constraint;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import org.woz.protozoa.core.item.Item;

/**
 * Checks whether a given {@link org.glassfish.jersey.examples.beanvalidation.webapp.domain.ContactCard} entity has ID.
 * Only return values are supposed to be annotated with this annotation.
 *
 * @author wolfgang
 */

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {HasId.Validator.class, HasId.ListValidator.class})
public @interface HasId {

    String message() default "{org.glassfish.jersey.examples.beanvalidation.webapp.constraint.HasId.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    public class Validator implements ConstraintValidator<HasId, Item>  {

        @Override
        public void initialize(final HasId hasId) {
        }

        @Override
        public boolean isValid(final Item contact, final ConstraintValidatorContext constraintValidatorContext) {
            return contact == null || contact.getId() != null;
        }
    }

    public class ListValidator implements ConstraintValidator<HasId, List<Item>>  {

        private Validator validator = new Validator();

        @Override
        public void initialize(final HasId hasId) {
        }

        @Override
        public boolean isValid(final List<Item> contacts, final ConstraintValidatorContext constraintValidatorContext) {
            boolean isValid = true;
            for (final Item contactCard : contacts) {
                isValid &= validator.isValid(contactCard, constraintValidatorContext);
            }
            return isValid;
        }
    }
}
