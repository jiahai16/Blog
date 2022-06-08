package com.xjh.blog.bean;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "article")
public class Article {
    @Id
    private Long id;
    private String title;
    private String date;
    private String description;
    private String content;
    private Date created;
    private Integer status;
}
