package org.chobit.common.base;

import java.io.Serializable;

/**
 * 参数相关异常
 *
 * @author robin
 */
public class ParamException extends RuntimeException implements Serializable {

    /**
     * 状态码
     */
    private int code;

    /**
     * 异常信息
     */
    private String msg;


    public ParamException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public ParamException(String msg) {
        this.code = 10000;
        this.msg = msg;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
