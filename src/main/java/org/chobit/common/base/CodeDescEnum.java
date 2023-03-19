package org.chobit.common.base;

/**
 * 枚举需要返回code和描述时可以继承此类
 *
 * @author robin
 */
public interface CodeDescEnum extends BaseEnum {


    /**
     * 返回描述信息
     *
     * @return 描述信息
     */
    String getDesc();

}
