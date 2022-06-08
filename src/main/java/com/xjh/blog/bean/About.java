package com.xjh.blog.bean;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "about")
public class About {
    @Id
    private Integer id;
    private String name;
    private String words;
}
