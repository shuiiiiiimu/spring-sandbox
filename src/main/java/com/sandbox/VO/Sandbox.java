package com.sandbox.VO;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by mike on 2017/2/21.
 */
public class Sandbox implements Serializable {

    private String msg;
    private Long status;
    private Map<String, Object> result;

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

    public Map<String, Object> getResult() {
        return result;
    }

    public void setResult(Map<String, Object> result) {
        this.result = result;
    }
}
