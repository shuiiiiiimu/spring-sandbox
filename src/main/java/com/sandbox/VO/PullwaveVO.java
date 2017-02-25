package com.sandbox.VO;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by mike on 2017/2/25.
 */
public class PullwaveVO  implements Serializable{
    private List<Map<String, String>> qushi;

    public List<Map<String, String>> getQushi() {
        return qushi;
    }

    public void setQushi(List<Map<String, String>> qushi) {
        this.qushi = qushi;
    }

    @Override
    public String toString() {
        return "PullwaveVO{" +
                "qushi size is " + qushi.size() +
                '}';
    }
}
