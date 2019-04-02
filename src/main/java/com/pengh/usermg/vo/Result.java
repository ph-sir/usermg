package com.pengh.usermg.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author PENGHUI
 * @date create on 2019/3/26
 */
@Setter
@Getter
@ToString
public class Result<T> {

    private Integer code;

    private String msg;

    private String url;

    private T data;



}
