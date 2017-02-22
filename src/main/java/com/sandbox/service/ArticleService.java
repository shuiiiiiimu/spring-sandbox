package com.sandbox.service;

import com.sandbox.VO.ArticleVO;
import com.sandbox.VO.UserVO;
import com.sandbox.domain.Article;
import com.sandbox.domain.User;
import com.sandbox.repository.ArticleRepository;
import com.sandbox.repository.UserRepository;
import com.sandbox.utils.MockUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mike on 2017/2/21.
 */
@Service
public class ArticleService {
    private static final Logger logger =  LoggerFactory.getLogger(ArticleService.class);

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private MockUtils mockUtils;

    public List<ArticleVO> findAll(){
        List<Article> articles = (List<Article>)articleRepository.findAll();
        List<ArticleVO> articleVOs = new ArrayList<>();
        articles.stream().filter(entity -> null != entity).forEach(entity -> {
            logger.debug(String.format("=> finded %s", entity.toString()));
            ArticleVO articleVO = new ArticleVO();
            articleVO.setContent(entity.getContent());
            articleVO.setTitle(entity.getTitle());
            articleVO.setAuthor(new UserVO(entity.getAuthor()));
            articleVO.setId(entity.getId());
            articleVOs.add(articleVO);
        });
        return articleVOs;
    }

    public void saveMany(){
        List<Article> articles = mockUtils.generateArticles();
        articles.forEach(article -> {
            articleRepository.save(article);
            logger.debug(String.format("=> Insertd %s", article.toString()));
        });
    }
}
