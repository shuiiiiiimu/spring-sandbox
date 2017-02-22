package com.sandbox.repository;

import com.sandbox.domain.Article;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mike on 2017/2/21.
 */
@Repository
public interface ArticleRepository extends CrudRepository<Article, Long>{

}
