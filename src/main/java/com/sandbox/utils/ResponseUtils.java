package com.sandbox.utils;

/**
 * Created by mike on 2017/2/21.
 */
public class ResponseUtils {

    private ResponseUtils(){}

    public static final Long SUCCESS_CODE = 200L;
    public static final String SUCCESS_MSG = "OK";

    public static final Long ERROR_CODE = 500L;
    public static final String ERROR_MSG = "发生未知错误";

    public static final Long NOT_FOUND_CODE = 404L;
    public static final String NOT_FOUND_MSG = "不存在当前地址";
}
