package com.xjh.blog.bean;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "subscription")
public class Subscription {
    @Id
    private Integer id;
    private String nickname;
    private String email;
    private Integer status;
}
