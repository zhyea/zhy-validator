package org.chobit.common.validation;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.chobit.common.base.CheckableType;

/**
 * 整体检查验证
 *
 * @author robin
 */
public class WholeCheckValidator implements ConstraintValidator<WholeCheck, CheckableType> {


    @Override
    public void initialize(WholeCheck anno) {
    }


    @Override
    public boolean isValid(CheckableType checkableObj, ConstraintValidatorContext context) {
        return checkableObj.check();
    }
}
