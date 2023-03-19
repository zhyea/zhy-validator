package org.chobit.common.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.chobit.common.constants.CommonRegexPattern;

import java.lang.annotation.*;

/**
 * 通用正则校验注解
 *
 * @author robin
 */
@Documented
@Constraint(
        validatedBy = {CommonPatternValidator.class}
)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CommonPattern {


    Class<?>[] groups() default {};


    Class<? extends Payload>[] payload() default {};


    /**
     * 正则表达式
     *
     * @return 正则表达式
     */
    CommonRegexPattern pattern();

    /**
     * 提示消息
     *
     * @return 提示消息
     */
    String message() default "不能通过正则校验";


}
