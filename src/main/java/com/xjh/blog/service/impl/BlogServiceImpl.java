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
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Resource
    private ArticleMapper articleMapper;

    @Resource
    private AboutMapper aboutMapper;

    @Resource
    private SubscriptionMapper subscriptionMapper;


    @Override
    public List<About> selectAbout() {
        try {
            return aboutMapper.selectAll();
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
}
