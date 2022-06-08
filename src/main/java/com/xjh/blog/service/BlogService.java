package com.xjh.blog.service;

import com.xjh.blog.bean.About;

import java.util.List;

public interface BlogService {
    List<About> selectAbout();

    Boolean insertAbout(About about);

    Boolean updateAboutById(About about);

    Boolean removeAboutById(Integer id);
}
