package com.sandbox.utils;

import com.sandbox.domain.Article;
import com.sandbox.domain.User;
import com.sandbox.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mike on 2017/2/21.
 */
@Component
public class MockUtils {

    @Autowired
    private UserRepository userRepository;

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

    public List<Article> generateArticles(){
        List<Article> articles = new ArrayList<>();
        List<Long> userIds = Arrays.asList(1L, 2L);
        userIds.forEach(userId -> {
            Article article = new Article();
            article.setAuthor(userRepository.findOne(userId));
            article.setContent("title" + String.valueOf(System.currentTimeMillis()));
            article.setTitle("content" + String.valueOf(System.currentTimeMillis()));
            articles.add(article);
        });
        return articles;
    }
}
