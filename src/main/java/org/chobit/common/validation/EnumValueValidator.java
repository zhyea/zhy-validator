package org.chobit.common.validation;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.chobit.common.base.CodeEnum;
import org.chobit.common.utils.EnumKit;

/**
 * 枚举值验证
 *
 * @author robin
 */
public class EnumValueValidator implements ConstraintValidator<EnumValue, Integer> {


    /**
     * 枚举类型
     */
    private Class<? extends Enum<? extends CodeEnum>> enumClass;

    /**
     * 已排除的枚举code值
     */
    private int[] excludeCodes;


    @Override
    public void initialize(EnumValue enumVal) {
        this.enumClass = enumVal.enumClass();
        if (!CodeEnum.class.isAssignableFrom(this.enumClass)) {
            throw new IllegalArgumentException(this.enumClass + "不是继承自BaseEnum");
        }
        this.excludeCodes = enumVal.exclude();
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (null == value) {
            return true;
        }

        if (null != excludeCodes && excludeCodes.length != 0) {
            for (int code : excludeCodes) {
                if (code == value) {
                    return false;
                }
            }
        }

        CodeEnum e = EnumKit.enumOf(value, this.enumClass);

        return null != e;
    }
}
