package org.chobit.common.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * 检查是否全部是汉字
 *
 * @author robin
 */
@Documented
@Constraint(
        validatedBy = {ChineseOnlyValidator.class}
)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ChineseOnly {


    Class<?>[] groups() default {};


    Class<? extends Payload>[] payload() default {};


    /**
     * 提示消息
     *
     * @return 提示消息
     */
    String message() default "存在非法字符";


    /**
     * 是否允许中文标点符号
     *
     * @return true 允许， false 不允许
     */
    boolean allowPunctuation() default false;

}
