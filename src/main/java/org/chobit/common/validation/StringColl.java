package org.chobit.common.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.chobit.common.funcs.Checker;

import java.lang.annotation.*;

/**
 * 字符串
 *
 * @author robin
 */
@Documented
@Constraint(
        validatedBy = {StringCollValidator.class}
)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface StringColl {


    Class<?>[] groups() default {};


    Class<? extends Payload>[] payload() default {};


    /**
     * 字符串校验类
     *
     * @return 字符串校验类
     */
    Class<? extends Checker<String>> checker() default Checker.StringDefault.class;


    /**
     * 提示消息
     *
     * @return 提示消息
     */
    String message() default "存在空字符串";
}
