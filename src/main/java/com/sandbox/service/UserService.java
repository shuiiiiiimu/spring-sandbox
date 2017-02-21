package com.sandbox.service;

import com.sandbox.VO.UserVO;
import com.sandbox.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandbox.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mike on 2017/2/21.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserVO> findAll(){
        List<User> users = (List<User>)userRepository.findAll();
        List<UserVO> userVOs = new ArrayList<>();
        users.stream().filter(entity -> null != entity).forEach(entity -> {
            UserVO userVO = new UserVO();
            userVO.setId(entity.getId());
            userVO.setName(entity.getName());
            userVOs.add(userVO);
        });
        return userVOs;
    }
}
