package org.chobit.common.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * 校验是否存在emoji字符
 *
 * @author robin
 */
@Documented
@Constraint(
        validatedBy = {NoEmojiValidator.class}
)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NoEmoji {


    Class<?>[] groups() default {};


    Class<? extends Payload>[] payload() default {};


    /**
     * 提示消息
     *
     * @return 提示消息
     */
    String message() default "存在emoji符号";
}
