package org.chobit.common.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.chobit.common.base.BaseEnum;

import java.lang.annotation.*;

/**
 * 枚举值验证注解
 *
 * @author baifeng.sun
 */
@Documented
@Constraint(
        validatedBy = {EnumValueValidator.class}
)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EnumValue {


    Class<?>[] groups() default {};


    Class<? extends Payload>[] payload() default {};

    /**
     * 枚举类型
     *
     * @return 枚举类类型
     */
    Class<? extends Enum<? extends BaseEnum>> enumClass();


    /**
     * 可排除的枚举值
     *
     * @return 可排除的枚举值
     */
    int[] exclude() default {};


    /**
     * 提示消息
     *
     * @return 提示消息
     */
    String message() default "非法的枚举值";
}
