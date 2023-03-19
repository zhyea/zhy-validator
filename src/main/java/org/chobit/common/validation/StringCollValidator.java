package org.chobit.common.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.chobit.common.funcs.Checker;

import java.util.Collection;

/**
 * 字符串集合检查校验
 *
 * @author robin
 */
public class StringCollValidator implements ConstraintValidator<StringColl, Collection<String>> {


    private Checker<String> checker;

    @Override
    public void initialize(StringColl anno) {
        Class<? extends Checker<String>> checkerClass = anno.checker();
        try {
            this.checker = checkerClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public boolean isValid(Collection<String> coll, ConstraintValidatorContext context) {
        if (null == coll || coll.isEmpty()) {
            return true;
        }

        for (String s : coll) {
            boolean r = this.checker.check(s);
            if (!r) {
                return false;
            }
        }

        return true;
    }
}
