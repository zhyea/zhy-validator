package org.chobit.common.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.chobit.common.base.BaseEnum;

import java.lang.annotation.*;

/**
 * 枚举值集合验证注解
 *
 * @author robin
 */
@Documented
@Constraint(
        validatedBy = {EnumCollValidator.class}
)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EnumColl {


    Class<?>[] groups() default {};


    Class<? extends Payload>[] payload() default {};

    /**
     * 枚举类型
     *
     * @return 枚举类类型
     */
    Class<? extends Enum<? extends BaseEnum>> enumClass();


    /**
     * 提示消息
     *
     * @return 提示消息
     */
    String message() default "存在非法的枚举值";
}
