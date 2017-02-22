package com.sandbox.utils;

import com.sandbox.domain.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mike on 2017/2/21.
 */
@Component
public class MockUtils {

    public List<User> generteUsers(){
        List<User> users = new ArrayList<>();
        List<String> names = Arrays.asList("mike", "logger", "superman");
        names.stream().forEach(name -> {
            User user = new User();
            user.setName(name);
            user.setEmail(String.format("%s@sandbox.com", name));
            user.setMobile(String.valueOf(System.currentTimeMillis()));
            users.add(user);
        });
        return users;
    }
}
