package com.sandbox.VO;

import com.sandbox.utils.ResponseUtils;

import java.io.Serializable;

/**
 * Created by mike on 2017/2/21.
 */
public class Sandbox<T> implements Serializable {

    private String msg = ResponseUtils.SUCCESS_MSG;
    private Long status = ResponseUtils.SUCCESS_CODE;
    private T result;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
