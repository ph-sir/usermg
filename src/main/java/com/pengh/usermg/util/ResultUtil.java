package com.pengh.usermg.util;

import com.pengh.usermg.vo.Result;

/**
 * @author PENGHUI
 * @date create on 2019/3/26
 */
public class ResultUtil {

    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(200);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static Result loginFail(String msg) {
        return error(201, msg);
    }

}
