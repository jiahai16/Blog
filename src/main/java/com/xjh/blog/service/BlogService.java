package com.xjh.blog.service;

import com.xjh.blog.bean.About;
import com.xjh.blog.bean.Article;
import com.xjh.blog.bean.Subscription;

import java.util.List;

public interface BlogService {
    List<About> selectAbout(Integer id);

    Boolean insertAbout(About about);

    Boolean updateAboutById(About about);

    Boolean removeAboutById(Integer id);

    List<Article> selectArticle(Long id);

    Boolean insertArticle(Article article);

    Boolean updateArticleById(Article article);

    Boolean removeArticleById(Long id);

    List<Subscription> selectSubscription(Integer id);

    Boolean insertSubscription(Subscription subscription);

    Boolean updateSubscriptionById(Subscription subscription);

    Boolean removeSubscriptionById(Integer id);
}
