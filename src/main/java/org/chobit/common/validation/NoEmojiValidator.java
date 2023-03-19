package org.chobit.common.validation;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.chobit.common.utils.CharacterChecker;

/**
 * @author robin
 */
public class NoEmojiValidator implements ConstraintValidator<NoEmoji, String> {


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (null == value) {
            return true;
        }

        return !CharacterChecker.containsEmoji(value);
    }


}
