package org.chobit.common.base;

/**
 * 可检查类型
 * <p>
 * 当需要对一个对象进行整体检查时可以继承这个接口
 *
 * @author robin
 */
public interface CheckableType {


    /**
     * 对Bean执行检查
     *
     * @return true 没有错误， false 存在错误
     * @throws ParamException 参数异常
     */
    boolean check() throws ParamException;

}
