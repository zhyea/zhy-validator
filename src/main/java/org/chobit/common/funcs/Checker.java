package org.chobit.common.funcs;


import static org.chobit.common.utils.StrKit.isNotBlank;

/**
 * 目标校验函数，通常用于对集合对象中单个元素的校验
 *
 * @author robin
 */
public interface Checker<T> {


    /**
     * 对目标值执行校验
     *
     * @param value 目标值
     * @return 校验结果
     */
    boolean check(T value);


    /**
     * 默认字符串校验工具类
     * <p>
     * 仅用来判断字符串是否为空
     */
    class StringDefault implements Checker<String> {

        @Override
        public boolean check(String value) {
            return isNotBlank(value);
        }

    }

}
