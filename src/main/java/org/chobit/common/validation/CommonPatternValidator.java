package org.chobit.common.validation;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.chobit.common.constants.CommonRegexPattern;

/**
 * @author robin
 */
public class CommonPatternValidator implements ConstraintValidator<CommonPattern, String> {


    private CommonRegexPattern regexPattern;

    @Override
    public void initialize(CommonPattern annotation) {
        this.regexPattern = annotation.pattern();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (null == value) {
            return false;
        }

        return this.regexPattern.pattern.matcher(value).matches();
    }
}
