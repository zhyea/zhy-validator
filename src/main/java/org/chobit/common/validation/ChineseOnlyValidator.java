package org.chobit.common.validation;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.chobit.common.utils.CharacterChecker;

/**
 * @author robin
 */
public class ChineseOnlyValidator implements ConstraintValidator<ChineseOnly, String> {


    private boolean allowPunctuation;

    @Override
    public void initialize(ChineseOnly annotation) {
        this.allowPunctuation = annotation.allowPunctuation();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (null == value) {
            return false;
        }

        return CharacterChecker.isChineseOnly(value, this.allowPunctuation);
    }
}
