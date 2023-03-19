package org.chobit.common.utils;


import org.chobit.common.base.CodeDescEnum;
import org.chobit.common.base.BaseEnum;

/**
 * @author robin
 */
public final class BaseEnumKit {


    /**
     * 获取枚举值code对应的描述
     *
     * @param code  枚举值code
     * @param clazz 枚举类
     * @return 枚举值对应的desc
     */
    public static String descOf(Integer code, Class<? extends Enum<? extends CodeDescEnum>> clazz) {
        BaseEnum v = enumOf(code, clazz);

        if(v instanceof CodeDescEnum){
            return ((CodeDescEnum)v).getDesc();
        }
        return null;
    }


    /**
     * 获取code对应的枚举值
     *
     * @param code  枚举值code
     * @param clazz 枚举类
     * @return code对应的枚举值
     */
    public static BaseEnum enumOf(Integer code, Class<? extends Enum<? extends BaseEnum>> clazz) {
        if (null == code) {
            return null;
        }

        if (!BaseEnum.class.isAssignableFrom(clazz)) {
            return null;
        }

        Enum<?>[] values = clazz.getEnumConstants();
        for (Enum<?> e : values) {
            BaseEnum val = (BaseEnum) e;
            if (code.equals(val.getCode())) {
                return val;
            }
        }

        return null;
    }


    /**
     * 根据code获取枚举值
     *
     * @param code 枚举对应code值
     * @param <T>  枚举类型实例
     * @return 枚举值
     */
    public static <T extends Enum<?> & BaseEnum> T codeOf(Class<T> enumType, int code) {

        T[] values = enumType.getEnumConstants();

        if (values == null) {
            return null;
        }

        for (T v : values) {
            if (v.getCode().equals(code)) {
                return v;
            }
        }

        return null;
    }


    private BaseEnumKit() {
    }

}
