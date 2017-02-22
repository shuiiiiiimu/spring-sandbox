package com.sandbox.VO;


import java.io.Serializable;

/**
 * Created by mike on 2017/2/21.
 */
public class ArticleVO implements Serializable {
    private Long id;
    private String title;
    private String content;
    private UserVO author;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserVO getAuthor() {
        return author;
    }

    public void setAuthor(UserVO author) {
        this.author = author;
    }
}
