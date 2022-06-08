package com.xjh.blog;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@Slf4j
@MapperScan("com.xjh.blog.mapper")
@SpringBootApplication(scanBasePackages = "com.xjh")
public class BlogWebApplication {
    private static Logger logger = LoggerFactory.getLogger(BlogWebApplication.class);

    public static void main(String[] args){

        SpringApplication.run(BlogWebApplication.class, args);
        logger.info("=============================spring boot start successful !=============================");
    }
}
