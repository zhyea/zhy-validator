package org.chobit.common.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * 完全依赖自定义的检查
 * <p>
 * 该注解可以用在任何一个返回值类型为Boolean的方法上
 *
 * @author robin
 */
@Documented
@Constraint(
        validatedBy = {SelfCheckValidator.class}
)
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SelfCheck {


    Class<?>[] groups() default {};


    Class<? extends Payload>[] payload() default {};


    /**
     * 提示消息
     *
     * @return 提示消息
     */
    String message() default "无法通过校验";

}
