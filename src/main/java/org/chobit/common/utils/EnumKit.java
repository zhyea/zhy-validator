package org.chobit.common.utils;


import org.chobit.common.base.CodeDescEnum;
import org.chobit.common.base.CodeEnum;

/**
 * 枚举工具类
 * <p>
 * 主要用来处理继承了{@see org.chobit.common.base.CodeEnum}和{@see org.chobit.common.base.CodeDescEnum}接口的枚举
 *
 * @author robin
 */
public final class EnumKit {


    /**
     * 获取枚举值code对应的描述
     *
     * @param code  枚举值code
     * @param clazz 枚举类
     * @return 枚举值对应的desc
     */
    public static String descOf(Integer code, Class<? extends Enum<? extends CodeDescEnum>> clazz) {
        CodeEnum v = enumOf(code, clazz);

        if (v instanceof CodeDescEnum) {
            return ((CodeDescEnum) v).getDesc();
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
    public static CodeEnum enumOf(Integer code, Class<? extends Enum<? extends CodeEnum>> clazz) {
        if (null == code) {
            return null;
        }

        if (!CodeEnum.class.isAssignableFrom(clazz)) {
            return null;
        }

        Enum<?>[] values = clazz.getEnumConstants();
        for (Enum<?> e : values) {
            CodeEnum val = (CodeEnum) e;
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
    public static <T extends Enum<?> & CodeEnum> T codeOf(Class<T> enumType, int code) {

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


    private EnumKit() {
        throw new UnsupportedOperationException("Private constructor, cannot be accessed.");
    }

}
