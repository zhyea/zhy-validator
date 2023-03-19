package org.chobit.common.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.math.BigInteger;
import java.util.List;

/**
 * 枚举值验证
 *
 * @author robin
 */
public class ListBigIntegerValidator implements ConstraintValidator<ListBigInteger, List<BigInteger>> {


    private long max;


    private long min;


    @Override
    public void initialize(ListBigInteger ll) {
        this.max = ll.max();
        this.min = ll.min();
    }

    @Override
    public boolean isValid(List<BigInteger> list, ConstraintValidatorContext context) {
        if (null==list || list.isEmpty()) {
            return true;
        }

        for (BigInteger v : list) {
            if (v.compareTo(BigInteger.valueOf(this.min)) < 0) {
                return false;
            }
            if (v.compareTo(BigInteger.valueOf(this.max)) > 0) {
                return false;
            }
        }

        return true;
    }
}
