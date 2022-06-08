package com.xjh.blog.controller;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.xjh.blog.bean.About;
import com.xjh.blog.exception.CommonException;
import com.xjh.blog.model.ResultModel;
import com.xjh.blog.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Resource
    private BlogService blogService;

    @GetMapping("/about")
    public ResultModel<List<About>> getAbout(){
        try{
            List<About> res = blogService.selectAbout();
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
}
