package com.sandbox.VO;

import com.sandbox.domain.User;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by mike on 2017/2/21.
 */
public class UserVO implements Serializable {
    private Long id;
    private String name;
    private String email;
    private Map<String, Object> arrtibutes;

    public UserVO(){}

    public UserVO(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Map<String, Object> getArrtibutes() {
        return arrtibutes;
    }

    public void setArrtibutes(Map<String, Object> arrtibutes) {
        this.arrtibutes = arrtibutes;
    }
}
