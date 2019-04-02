package com.pengh.usermg.enums;

/**
 * @author PENGHUI
 * @date create on 2019/3/26
 */
public enum  ResultEnum {

    UNKNOWN_ERROR(-1, "未知错误"),
    SUCCESS(200, "成功");
    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
