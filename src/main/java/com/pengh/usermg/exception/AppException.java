package com.pengh.usermg.exception;

import com.pengh.usermg.enums.ResultEnum;

/**
 * @author PENGHUI
 * @date create on 2019/3/26
 */
public class AppException extends RuntimeException {

    private Integer code;

    public AppException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
