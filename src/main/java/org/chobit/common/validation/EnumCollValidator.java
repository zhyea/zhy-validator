package org.chobit.common.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.chobit.common.base.CodeEnum;
import org.chobit.common.utils.EnumKit;

import java.util.Collection;

/**
 * 枚举值验证
 *
 * @author robin
 */
public class EnumCollValidator implements ConstraintValidator<EnumColl, Collection<Integer>> {


    private Class<? extends Enum<? extends CodeEnum>> enumClass;


    @Override
    public void initialize(EnumColl enumVal) {
        this.enumClass = enumVal.enumClass();
        if (!CodeEnum.class.isAssignableFrom(this.enumClass)) {
            throw new RuntimeException(this.enumClass + "不是继承自BaseEnum");
        }
    }

    @Override
    public boolean isValid(Collection<Integer> coll, ConstraintValidatorContext context) {
        if (null == coll || coll.isEmpty()) {
            return true;
        }

        for (Integer e : coll) {
            CodeEnum enumVal = EnumKit.enumOf(e, this.enumClass);
            if (null == enumVal) {
                return false;
            }
        }

        return true;
    }
}
