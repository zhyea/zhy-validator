package org.chobit.common.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;

/**
 * 对一个对象做整体性校验
 *
 * @author robin
 */
@Documented
@Constraint(
        validatedBy = {WholeCheckValidator.class}
)
@Target({TYPE, PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface WholeCheck {


    Class<?>[] groups() default {};


    Class<? extends Payload>[] payload() default {};


    /**
     * 提示消息
     *
     * @return 提示消息
     */
    String message() default "对象校验出错";

}
