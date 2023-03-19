package org.chobit.common.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * 整型（含int和long）数字集合
 *
 * @author robin
 */
@Documented
@Constraint(
        validatedBy = {ListBigIntegerValidator.class}
)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ListBigInteger {


    Class<?>[] groups() default {};


    Class<? extends Payload>[] payload() default {};


    /**
     * 提示消息
     *
     * @return 提示消息
     */
    String message() default "存在非法值";

    /**
     * 集合元素的最大值
     *
     * @return 集合元素最大值
     */
    long max() default Long.MAX_VALUE;


    /**
     * 集合元素的最小值
     *
     * @return 集合元素最小值
     */
    long min() default 0L;


}
