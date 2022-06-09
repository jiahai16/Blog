package com.xjh.blog.controller;

import com.xjh.blog.bean.About;
import com.xjh.blog.bean.Article;
import com.xjh.blog.bean.Subscription;
import com.xjh.blog.exception.CommonException;
import com.xjh.blog.model.ResultModel;
import com.xjh.blog.service.BlogService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Resource
    private BlogService blogService;

    /*About Controller*/
    @GetMapping("/about")
    public ResultModel<List<About>> getAbout(@RequestParam(required = false, defaultValue = "-1", value = "id") Integer id){
        try{
            List<About> res = blogService.selectAbout(id);
            return ResultModel.success(res);
        }catch (CommonException e){
            return ResultModel.fail(e);
        }
    }

    @PostMapping("/about")
    public ResultModel<Boolean> saveAbout(@RequestBody About about){
        try{
            Boolean res = blogService.insertAbout(about);
            return ResultModel.success(res);
        }catch (CommonException e){
            return ResultModel.fail(e);
        }
    }

    @PutMapping("/about")
    public ResultModel<Boolean> updateAbout(@RequestBody About about){
        try{
            Boolean res = blogService.updateAboutById(about);
            return ResultModel.success(res);
        }catch (CommonException e){
            return ResultModel.fail(e);
        }
    }

    @DeleteMapping("/about")
    public ResultModel<Boolean> removeAbout(@RequestBody About about){
        try{
            Boolean res = blogService.removeAboutById(about.getId());
            return ResultModel.success(res);
        }catch (CommonException e){
            return ResultModel.fail(e);
        }
    }

    /*Article Controller*/
    @GetMapping("/article")
    public ResultModel<List<Article>> getArticle(@RequestParam(required = false, defaultValue = "-1", value = "id") Long id){
        try{
            List<Article> res = blogService.selectArticle(id);
            return ResultModel.success(res);
        }catch (CommonException e){
            return ResultModel.fail(e);
        }
    }

    @PostMapping("/article")
    public ResultModel<Boolean> saveArticle(@RequestBody Article article){
        try{
            Boolean res = blogService.insertArticle(article);
            return ResultModel.success(res);
        }catch (CommonException e){
            return ResultModel.fail(e);
        }
    }

    @PutMapping("/article")
    public ResultModel<Boolean> updateArticle(@RequestBody Article article){
        try{
            Boolean res = blogService.updateArticleById(article);
            return ResultModel.success(res);
        }catch (CommonException e){
            return ResultModel.fail(e);
        }
    }

    @DeleteMapping("/article")
    public ResultModel<Boolean> removeArticle(@RequestBody Article article){
        try{
            Boolean res = blogService.removeArticleById(article.getId());
            return ResultModel.success(res);
        }catch (CommonException e){
            return ResultModel.fail(e);
        }
    }


    /*Subscription Controller*/
    @GetMapping("/subscription")
    public ResultModel<List<Subscription>> getSubscription(@RequestParam(required = false, defaultValue = "-1", value = "id") Integer id){
        try{
            List<Subscription> res = blogService.selectSubscription(id);
            return ResultModel.success(res);
        }catch (CommonException e){
            return ResultModel.fail(e);
        }
    }

    @PostMapping("/subscription")
    public ResultModel<Boolean> saveArticle(@RequestBody Subscription subscription){
        try{
            Boolean res = blogService.insertSubscription(subscription);
            return ResultModel.success(res);
        }catch (CommonException e){
            return ResultModel.fail(e);
        }
    }

    @PutMapping("/subscription")
    public ResultModel<Boolean> updateArticle(@RequestBody Subscription subscription){
        try{
            Boolean res = blogService.updateSubscriptionById(subscription);
            return ResultModel.success(res);
        }catch (CommonException e){
            return ResultModel.fail(e);
        }
    }

    @DeleteMapping("/subscription")
    public ResultModel<Boolean> removeArticle(@RequestBody Subscription subscription){
        try{
            Boolean res = blogService.removeSubscriptionById(subscription.getId());
            return ResultModel.success(res);
        }catch (CommonException e){
            return ResultModel.fail(e);
        }
    }
}
