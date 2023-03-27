package org.chobit.common.base;

/**
 * 枚举接口
 * <p>
 * 接口需要返回Code时可继承此类
 *
 * @author robin
 */
public interface CodeEnum {


    /**
     * 返回code值
     *
     * @return code值
     */
    Integer getCode();


    /**
     * 判断状态值是否与枚举值code匹配
     *
     * @param code 资金单状态code
     * @return true 匹配， false 不匹配
     */
    default boolean is(Integer code) {
        if (null == code) {
            return false;
        }
        return this.getCode().equals(code);
    }

}
