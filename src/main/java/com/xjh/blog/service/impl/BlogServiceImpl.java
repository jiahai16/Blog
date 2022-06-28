package com.xjh.blog.service.impl;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.xjh.blog.bean.About;
import com.xjh.blog.bean.Article;
import com.xjh.blog.bean.Subscription;
import com.xjh.blog.exception.CommonErrorCode;
import com.xjh.blog.exception.CommonException;
import com.xjh.blog.mapper.AboutMapper;
import com.xjh.blog.mapper.ArticleMapper;
import com.xjh.blog.mapper.SubscriptionMapper;
import com.xjh.blog.service.BlogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Resource
    private ArticleMapper articleMapper;

    @Resource
    private AboutMapper aboutMapper;

    @Resource
    private SubscriptionMapper subscriptionMapper;


    /*About Service*/

    @Override
    public List<About> selectAbout(Integer id) {
        try {
            if (id.equals(-1)){
                return aboutMapper.selectAll();
            }
            return Arrays.asList(aboutMapper.selectByPrimaryKey(id));
        }catch (Exception e){
            throw new CommonException(CommonErrorCode.UNKNOWN_ERROR);
        }
    }

    @Override
    public Boolean insertAbout(About about) {
        try {
            int count = aboutMapper.insertSelective(about);
            return count == 1;
        }catch (Exception e){
            throw new CommonException(CommonErrorCode.UNKNOWN_ERROR);
        }
    }

    @Override
    public Boolean updateAboutById(About about) {
        try {
            int count = aboutMapper.updateByPrimaryKeySelective(about);
            return count == 1;
        }catch (Exception e){
            throw new CommonException(CommonErrorCode.UNKNOWN_ERROR);
        }
    }

    @Override
    public Boolean removeAboutById(Integer id) {
        try {
            int count = aboutMapper.deleteByPrimaryKey(id);
            return count == 1;
        }catch (Exception e){
            throw new CommonException(CommonErrorCode.UNKNOWN_ERROR);
        }
    }

    /*Article Service*/

    @Override
    public List<Article> selectArticle(Long id) {
        try {
            List<Article> res;
            if (id.equals(-1L)){
                res = articleMapper.selectAll();
            }else {
                res = Arrays.asList(articleMapper.selectByPrimaryKey(id));
            }
            res.sort((o1,o2) -> o2.getCreated().compareTo(o1.getCreated()));
            return res;
        }catch (Exception e){
            throw new CommonException(CommonErrorCode.UNKNOWN_ERROR);
        }
    }

    @Override
    public Boolean insertArticle(Article article) {
        try {
            int count = articleMapper.insertSelective(article);
            return count == 1;
        }catch (Exception e){
            throw new CommonException(CommonErrorCode.UNKNOWN_ERROR);
        }
    }

    @Override
    public Boolean updateArticleById(Article article) {
        try {
            int count = articleMapper.updateByPrimaryKeySelective(article);
            return count == 1;
        }catch (Exception e){
            throw new CommonException(CommonErrorCode.UNKNOWN_ERROR);
        }
    }

    @Override
    public Boolean removeArticleById(Long id) {
        try {
            int count = articleMapper.deleteByPrimaryKey(id);
            return count == 1;
        }catch (Exception e){
            throw new CommonException(CommonErrorCode.UNKNOWN_ERROR);
        }
    }


    /*Subscription Service*/

    @Override
    public List<Subscription> selectSubscription(Integer id) {
        try {
            if (id.equals(-1)){
                return subscriptionMapper.selectAll();
            }
            return Arrays.asList(subscriptionMapper.selectByPrimaryKey(id));
        }catch (Exception e){
            throw new CommonException(CommonErrorCode.UNKNOWN_ERROR);
        }
    }

    @Override
    public Boolean insertSubscription(Subscription subscription) {
        try {
            int count = subscriptionMapper.insertSelective(subscription);
            return count == 1;
        }catch (Exception e){
            throw new CommonException(CommonErrorCode.UNKNOWN_ERROR);
        }
    }

    @Override
    public Boolean updateSubscriptionById(Subscription subscription) {
        try {
            int count = subscriptionMapper.updateByPrimaryKeySelective(subscription);
            return count == 1;
        }catch (Exception e){
            throw new CommonException(CommonErrorCode.UNKNOWN_ERROR);
        }
    }

    @Override
    public Boolean removeSubscriptionById(Integer id) {
        try {
            int count = subscriptionMapper.deleteByPrimaryKey(id);
            return count == 1;
        }catch (Exception e){
            throw new CommonException(CommonErrorCode.UNKNOWN_ERROR);
        }
    }
}
