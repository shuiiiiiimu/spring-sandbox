package com.sandbox.service;

import com.sandbox.VO.UserVO;
import com.sandbox.domain.User;
import com.sandbox.utils.MockUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger logger =  LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MockUtils mockUtils;

    public List<UserVO> findAll(){
        List<User> users = (List<User>)userRepository.findAll();
        List<UserVO> userVOs = new ArrayList<>();
        users.stream().filter(entity -> null != entity).forEach(entity -> {
            logger.debug(String.format("=> finded %s", entity.toString()));
            UserVO userVO = new UserVO();
            userVO.setId(entity.getId());
            userVO.setName(entity.getName());
            userVOs.add(userVO);
        });
        return userVOs;
    }

    public void saveMany(){
        List<User> users = mockUtils.generteUsers();
        users.forEach(user -> {
            userRepository.save(user);
            logger.debug(String.format("=> Insertd %s", user.toString()));
        });
    }
}
